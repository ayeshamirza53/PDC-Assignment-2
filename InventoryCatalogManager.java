import java.util.*;
import java.util.concurrent.*;

public class InventoryCatalogManager {

    public static void benchmarkSynchronizedMap(int numThreads, int opsPerThread) throws InterruptedException {
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
        syncMap.put("PROD_1", 1000);

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        long startTime = System.currentTimeMillis();

        for (int t = 0; t < numThreads; t++) {
            executor.submit(() -> {
                for (int i = 0; i < opsPerThread; i++) {
                    syncMap.get("PROD_1");
                    syncMap.put("PROD_1", i);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        long elapsedTime = System.currentTimeMillis() - startTime;

        double throughput = (numThreads * opsPerThread * 2.0) / (elapsedTime / 1000.0);
        System.out.println("Collections.synchronizedMap:");
        System.out.println("  Execution Time: " + elapsedTime + " ms");
        System.out.println("  Throughput: " + String.format("%.2f", throughput) + " ops/sec\n");
    }

    public static void benchmarkConcurrentMap(int numThreads, int opsPerThread) throws InterruptedException {
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("PROD_1", 1000);

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        long startTime = System.currentTimeMillis();

        for (int t = 0; t < numThreads; t++) {
            executor.submit(() -> {
                for (int i = 0; i < opsPerThread; i++) {
                    concurrentMap.get("PROD_1");
                    concurrentMap.put("PROD_1", i);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        long elapsedTime = System.currentTimeMillis() - startTime;

        double throughput = (numThreads * opsPerThread * 2.0) / (elapsedTime / 1000.0);
        System.out.println("ConcurrentHashMap (Bucket Locking):");
        System.out.println("  Execution Time: " + elapsedTime + " ms");
        System.out.println("  Throughput: " + String.format("%.2f", throughput) + " ops/sec\n");
    }

    public static void main(String[] args) throws InterruptedException {
        int threads = 10;
        int operations = 50000;

        System.out.println("=== BENCHMARKING MAP CONCURRENCY ARCHITECTURES ===");
        benchmarkSynchronizedMap(threads, operations);
        benchmarkConcurrentMap(threads, operations);
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log
