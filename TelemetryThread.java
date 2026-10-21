public class TelemetryThread extends Thread {
    public TelemetryThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + getName() + "] System Metrics Iteration: " + i + " | CPU & Memory Health OK");
            try {
                Thread.sleep(800); 
            } catch (InterruptedException e) {
                System.err.println("Telemetry Thread Interrupted");
            }
        }
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log

// Incremental commit update
