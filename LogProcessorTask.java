public class LogProcessorTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] Batch Log Iteration: " + i + " | Processing logs...");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.err.println("Log Thread Interrupted");
            }
        }
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log

// Incremental commit update
