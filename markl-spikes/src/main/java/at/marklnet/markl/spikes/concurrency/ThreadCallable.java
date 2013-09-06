package at.marklnet.markl.spikes.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadCallable {
    
    public static void main(String[] args) throws Exception {
        Callable<Integer> c = new Callable<Integer>() {

            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                return Integer.valueOf(9999);
            }
        };
          
          ExecutorService executor = Executors.newCachedThreadPool();

          final Future<Integer> result = executor.submit(c);
          
          System.out.println("isDone()=" + result.isDone());
          
          
          System.out.println("get()=" + result.get(5, TimeUnit.SECONDS).toString());
          
          System.out.println("isDone()=" + result.isDone());

          executor.shutdown();
    }

}
