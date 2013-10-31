package at.marklnet.markl.spikes.concurrency.executer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class ExecuterServiceTest extends AExecutionService {
    
    public static final int TIMEOUT = 3000;
    
    public static void main(String[] args) {
        
        ExecuterServiceTest service = new ExecuterServiceTest();
        service.initializeService();
        
        System.out.println("Eingabe: Tasknummer-Tasklaufzeit  / Timeout nach 2Sekunden (pro Task)");
        System.out.println("1) updateTask1");
        System.out.println("2) updateTask2");
        System.out.println("3) updateTask3");
        System.out.println("4) updateTask4");
        System.out.println("5) updateTask5");
        System.out.println("6) updateAllTasks");
        System.out.println("Q) Ende");
        
        final Pattern pattern = Pattern.compile("^(\\d)-(\\d+)$");
        
        Scanner keyboard = new Scanner(System.in);
        
        
        while (keyboard.hasNext()) {
            final String line = keyboard.next();
            
            System.out.println("Verarbeite Eingabe: " + line);
            
            if (line.equalsIgnoreCase("q")) {
                System.out.println("Ende");
                service.stopService();
                System.exit(0);
            }
            
            final Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                final int taskNummer = Integer.valueOf(matcher.group(1));
                final int taskDuration = Integer.valueOf(matcher.group(2));
                
                if (taskNummer > 0 || taskNummer <= 6) {
                    
                   if (taskNummer == 6) {
                       // Update all
                       List<ExecuteableTask> tasks = new ArrayList<ExecuteableTask>();
                       for (int i = 1; i <= 5; i++) {
                           tasks.add(new MyTask(taskNummer, taskDuration));
                       } 
                       service.executeTasks(tasks, TIMEOUT);
                   } else {
                       service.executeTask(new MyTask(taskNummer, taskDuration), TIMEOUT);  
                   }
                    
                } else {
                    System.out.println("Ungültige Tasknummer übergeben."); 
                }
            } else {
                System.out.println("Ungültige Eingabe! z.b.: 1-1000 für Task#1 und 1000ms Laufzeit");
            }
            
        }
    }
    
    static class MyTask extends ExecuteableTask {
        
        private static final Logger LOG = Logger.getLogger(MyTask.class);
                
        private long duration;
        
        public MyTask(int tasknummer, long duration) {
            super("updateTask" + tasknummer);
            this.duration = duration;
            
        }

        public Void call() throws Exception {
            LOG.info("TASKSTART: " + getDescription() + " Threadname: " + Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(duration);
            LOG.info("TASKEND: " + getDescription() + " - Duration: " + duration + "ms" + " Threadname: " + Thread.currentThread().getName());
            
            return null;
        }
    }
    

}
