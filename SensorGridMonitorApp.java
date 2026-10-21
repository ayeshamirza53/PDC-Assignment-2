import java.util.Random;

public class SensorGridMonitorApp {
    public static void main(String[] args) throws InterruptedException {
        int size = 50000;
        double[] telemetryData = new double[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            telemetryData[i] = rand.nextDouble() * 100.0;
        }

        int numThreads = 4;
        int chunkSize = size / numThreads;

        double[] minResults = new double[numThreads];
        double[] maxResults = new double[numThreads];
        Thread[] minWorkers = new Thread[numThreads];
        Thread[] maxWorkers = new Thread[numThreads];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? size : start + chunkSize;
            final int threadIdx = i;

            minWorkers[i] = new Thread(() -> {
                minResults[threadIdx] = new ParallelMinSearch(telemetryData, start, end).processGrid();
            });

            maxWorkers[i] = new Thread(() -> {
                maxResults[threadIdx] = new ParallelMaxSearch(telemetryData, start, end).processGrid();
            });

            minWorkers[i].start();
            maxWorkers[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            minWorkers[i].join();
            maxWorkers[i].join();
        }

        double globalMin = minResults[0];
        double globalMax = maxResults[0];
        for (int i = 1; i < numThreads; i++) {
            if (minResults[i] < globalMin) globalMin = minResults[i];
            if (maxResults[i] > globalMax) globalMax = maxResults[i];
        }

        long endTime = System.currentTimeMillis();

        System.out.println("=== IOT SENSOR GRID PARALLEL MONITORING ===");
        System.out.println("Global Min Temperature: " + String.format("%.2f", globalMin) + " °C");
        System.out.println("Global Max Vibration Spike: " + String.format("%.2f", globalMax));
        System.out.println("Parallel Reduction Time: " + (endTime - startTime) + " ms");
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log
