import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        int size = 10000;
        double[] assetPortfolio = new double[size];
        Random rand = new Random(42);

        for (int i = 0; i < size; i++) {
            assetPortfolio[i] = 100 + rand.nextDouble() * 900;
        }

        ForkJoinPool pool = new ForkJoinPool(); 

        long startTime = System.nanoTime();
        ParallelRiskCalculator riskTask = new ParallelRiskCalculator(assetPortfolio, 0, size);
        double totalRisk = pool.invoke(riskTask);
        long parallelTime = System.nanoTime() - startTime;

        PortfolioThresholdTask stressTask = new PortfolioThresholdTask(assetPortfolio, 0, size, 500.0);
        pool.invoke(stressTask);

        System.out.println("=== FORK/JOIN PORTFOLIO PERFORMANCE METRICS ===");
        System.out.println("Cumulative Portfolio Risk Score: " + String.format("%.2f", totalRisk));
        System.out.println("Parallel Processing Execution Time: " + (parallelTime / 1e6) + " ms");
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log
