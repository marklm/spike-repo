package at.marklnet.markl.spikes.concurrency;

/**
 * Test von join
 */
public class ThreadJoin {

    static class JoinerThread extends Thread {
        public int result;

        @Override
        public void run() {
            result = 1;
        }
    }

    public static void main(String[] args) throws Exception {

        JoinerThread t = new JoinerThread();
        t.start();
        
        // Waits for this Thread to die
        t.join();
        
        System.out.println(t.result);
        System.out.println(t.result == 1 ? "OK....." : "t.join() kommentiert ==> daher nicht wie erwarteted");
    }
}
