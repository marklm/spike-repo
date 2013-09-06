package at.marklnet.markl.spikes.concurrency;

/**
 * Test von Thread interrupt.
 * 
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("DEBUG #1-start");

                while (!isInterrupted()) {
                    System.out.println("... running ...");

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        /*
                         * Wenn die Ausgabe nur jede halbe Sekunde stattfindet, befindet sich der Thread fast die gesamte Zeit über in der
                         * Schlafmethode sleep(). Also wird vermutlich der interrupt() den Thread gerade beim Schlafen stören. Genau dann
                         * wird sleep() durch InterruptedException unterbrochen, und der catch-Behandler fängt die Ausnahme ein. Jetzt
                         * passiert aber etwas Unerwartetes: Durch die Unterbrechung wird das interne Flag zurückgesetzt, sodass
                         * isInterrupted() meint, die Unterbrechung habe gar nicht stattgefunden. Daher muss interrupt() erneut aufgerufen
                         * werden, da das Abbruch-Flag neu gesetzt werden muss und isInterrupted() das Ende bestimmen kann.
                         */
                        interrupt();
                        System.out.println("Interrupt in sleep()");
                    }
                }

                System.out.println("DEBUG #2-End");
            }
        };
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
