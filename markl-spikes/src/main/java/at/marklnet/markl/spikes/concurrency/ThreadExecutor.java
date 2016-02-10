package at.marklnet.markl.spikes.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Test von interface java.util.concurrent.Executor
 * 
 * Von dieser Schnittstelle gibt es bisher zwei wichtige Implementierungen:
 * 
 * - ThreadPoolExecutor. Die Klasse baut eine Sammlung von Threads auf, den Thread-Pool. Ausführungsanfragen werden von den freien Threads
 * übernommen.
 * 
 * - ScheduledThreadPoolExecutor. Eine Erweiterung von ThreadPoolExecutor um die Fähigkeit, zu bestimmen Zeiten oder mit bestimmten
 * Wiederholungen Befehle abzuarbeiten.
 * 
 * Die beiden Klassen haben nicht ganz so triviale Konstruktoren, und eine Utility-Klasse vereinfacht den Aufbau dieser speziellen
 * Executor-Objekte.
 * 
 * - class java.util.concurrent.Executors
 */
public class ThreadExecutor {
    
    public static void main(String[] args) throws Exception {
        final Runnable r1 = new Runnable() {
            public void run() {       
                System.out.println("A1 " + Thread.currentThread());
                System.out.println("A2 " + Thread.currentThread());

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

          };

          final Runnable r2 = new Runnable() {
            public void run() {
              System.out.println("B1 " + Thread.currentThread());
              System.out.println("B2 " + Thread.currentThread());
            }
          };  
          
          final ExecutorService executor = Executors.newCachedThreadPool();

          executor.execute(r1);
          executor.execute(r2);

          Thread.sleep(500);

          executor.execute(r1);
          executor.execute(r2);

          executor.shutdown();
    }

}
