package at.marklnet.markl.spikes.concurrency.executer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;


public class AExecutionService {
    
    private Logger logger = Logger.getLogger(this.getClass());
    
    /** The internal used Execution Service */
    private ExecutorService exectionService;
    
    /** List of tasks that has been added to be executed by the service */
    private List<Task> executions;
    
    private static final int CLEAN_UP_INTERVAL = 5;
    
    private Future<Void> cleanUpJob;
    
    final Lock executionsLock = new ReentrantLock(true);
    
    /**
     * Inits the service and starts background thread for clean up.
     * In case the service isn't used longer you should stop the service to save resources.
     */
    public void initializeService() {
        exectionService = Executors.newCachedThreadPool();
        executions = new ArrayList<Task>();
        
        // Create CleanUp Job
        cleanUpJob = exectionService.submit(new Callable<Void>() {

            public Void call() throws Exception {
                
                while (!exectionService.isShutdown()) {

                    logger.debug("Starting cleanup of executions.");
                    
                    executionsLock.lock();
                    logger.trace("Got the lock.");
                    
                    final Date now = new Date();
                    
                    final List<Task> tasksToRemove = new ArrayList<AExecutionService.Task>();
                    
                    // Iterate over all Tasks
                    if (!executions.isEmpty()) {
                        
                        for (Iterator<Task> iterator = executions.iterator(); iterator.hasNext();) {
                            final Task task = iterator.next();
                            
                            if (task.cancelIfExpired(now)) {
                                // Task is done or canceld, so we can remove it from executions
                                tasksToRemove.add(task);
                                logger.debug(String.format("Task [%s] will be removed from executions.", task));
                            }
                        }
                    }
                    
                    executions.removeAll(tasksToRemove);
    
                    if (logger.isTraceEnabled()) {
                        logger.trace(String.format("Cleanup of executions finished. %d tasks removed, size of executions %s.", 
                                                   tasksToRemove.size(), executions.size()));
                    }
                    
                    executionsLock.unlock();

                    logger.trace("Lock released, going to sleep interval time.");
                    // Wait for next clean up
                    TimeUnit.SECONDS.sleep(CLEAN_UP_INTERVAL);              
                }

                logger.info("CleanUp Job is ending.");
                return null;
            }
        });
    }
    
    /**
     * Stops the execution service and frees used resources.
     */
    public void stopService() {
        exectionService.shutdown();
        logger.info("Execution Service stopped.");
        
        cleanUpJob.cancel(true);
        logger.info("CleanUp Job stopped. " + cleanUpJob.isDone());
        
        exectionService = null;
        cleanUpJob = null;
        executions = null;
    }
      
    /**
     * Starts execution of given task.
     * 
     * @param task task to execute
     * @param timeOutInMillis max duration, timeout
     */
    public void executeTask(ExecuteableTask task, int timeOutInMillis) {
        final List<ExecuteableTask> list = new ArrayList<ExecuteableTask>();
        list.add(task);
        executeTasks(list, timeOutInMillis);
    }
    
    /**
     * Starts execution of given tasks.
     * 
     * @param tasks tasks to execute
     * @param timeOutInMillis max duration, timeout
     */
    public void executeTasks(List<ExecuteableTask> tasks, int timeOutInMillis) {
        if (exectionService == null) {
            throw new IllegalStateException("Ensure executionService is started properly."); 
        }
        
        if (tasks == null || tasks.isEmpty() || timeOutInMillis < 0) {
            throw new IllegalArgumentException(String.format("Check arguments! tasks=%s, timeOutInSeconds=%s", tasks, timeOutInMillis));
        }
   
        for (Iterator<ExecuteableTask> iterator = tasks.iterator(); iterator.hasNext();) {
            final ExecuteableTask singleTask = iterator.next();

            final Future<Void> future = exectionService.submit(singleTask);
            addExecution(future, singleTask.getDescription(), timeOutInMillis);
        }
    }

    /**
     * Adds a new Task to the executions.
     * 
     * @param future the future instance
     * @param timeOutInMs a value for timeout in milliseconds
     */
    private void addExecution(Future<Void> future, String description, int timeOutInMs) {
        final Task task = new Task(future, description, timeOutInMs);
        executionsLock.lock();
        executions.add(task);
        executionsLock.unlock(); 
    }
    
    /**
     * @return <code>true</code> in case there are still tasks in executions, otherwise <code>false</code>
     */
    public boolean isExecutingTasks() {
        return !executions.isEmpty();
    }
     
    /**
     * Enhancement of {@link Callable}.
     * Used to add a task to the execution service.
     * 
     * @author <a href="mailto:markus.markl@brz.gv.at">Markus Markl</a>
     */
    static abstract class ExecuteableTask implements Callable<Void> {
        
        private String description;
        
        public ExecuteableTask() {
            this.description = "SimpleExecution";
        }
        
        public ExecuteableTask(String description) {
            this.description = description;
        }

        /**
         * @return the description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description the description to set
         */
        public void setDescription(String description) {
            this.description = description;
        } 
    }
    
    private static class Task {
        
        private Logger logger = Logger.getLogger(Task.class);
       
        /** Time when this Task has been created */
        private Date creationTime;
        
        /** Time of expiration - TimeOut */
        private Date expireTime;
        
        private Future<Void> future;
        
        private String description;
        
        /**
         *  Default Timeout 15 Seconds.
         */
        public static final int DEFAULT_TIMEOUT = 15 * 1000;
        
        /**
         * C'tor creates a Task.
         * 
         * @param future
         *            the future instance
         * @param description
         *            any description
         */
        public Task(Future<Void> future, String description) {
            this.future = future;
            this.creationTime = new Date();
            this.expireTime = DateUtils.addMilliseconds(creationTime, DEFAULT_TIMEOUT);
            this.description = description;
        }

        /**
         * C'tor creates a Task.
         * 
         * @param future
         *            the future instance
         * @param description
         *            any description
         * @param timeOutInMs
         *            timeout for this task in millis
         */
        public Task(Future<Void> future, String description, int timeOutInMs) {
            this.future = future;
            this.creationTime = new Date();
            this.expireTime = DateUtils.addMilliseconds(creationTime, timeOutInMs);
            this.description = description;
        }
        
        /**
         * @param referenceDate a reference date, usually now.
         * 
         * @return <code>true</code> in case cancel was called on {@link Future} or it is already completed, otherwise <code>false</code>
         */
        public boolean cancelIfExpired(Date referenceDate) {
            if (future.isDone()) {
                logger.trace("future.isDone()=true; so there's no need to cancel the task.");
                return true;
            }
            
            if (isExpired(referenceDate)) {
                future.cancel(true);
                logger.trace("Expired task was canceled");
                return true;
            }
            
            return false;
        }
        
        /**
         * @param referenceDate a reference date, usually now.
         * 
         * @return <code>true</code> if reference date is after expire time (expired), otherwise <code>false</code>
         */
        public boolean isExpired(Date referenceDate) {
            return referenceDate.after(expireTime);
        }  
        
        @Override
        public String toString() {
            final StringBuilder str = new StringBuilder(description);
            str.append(" - expireTime: ").append(expireTime);
            return str.toString();
        }
    }
}
