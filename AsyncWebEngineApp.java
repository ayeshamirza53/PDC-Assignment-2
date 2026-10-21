public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("Default JVM Thread Name: " + Thread.currentThread().getName()); // Log main thread[cite: 8]

        // Instantiate threads with custom names[cite: 8]
        TelemetryThread telemetryWorker = new TelemetryThread("Telemetry-Worker");
        Thread logWorker = new Thread(new LogProcessorTask(), "Log-Worker");

        telemetryWorker.start();
        logWorker.start();

        System.out.println("Active Threads Started. Demonstrating Concurrent Execution...");
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log
