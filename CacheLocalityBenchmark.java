public class CacheLocalityBenchmark {
    private static final int N = 2000;
    private static double[][] matrix = new double[N][N];

    public static double traverseRowMajor() {
        double sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j]; 
            }
        }
        return sum;
    }

    public static double traverseColumnMajor() {
        double sum = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                sum += matrix[i][j]; 
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // Initialize matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 1.0;
            }
        }

        int iterations = 10;
        long totalRowTime = 0;
        long totalColTime = 0;

        for (int k = 0; k < iterations; k++) {
            long startRow = System.nanoTime();
            traverseRowMajor();
            totalRowTime += (System.nanoTime() - startRow);

            long startCol = System.nanoTime();
            traverseColumnMajor();
            totalColTime += (System.nanoTime() - startCol);
        }

        double avgRowTimeMs = (totalRowTime / (double) iterations) / 1e6;
        double avgColTimeMs = (totalColTime / (double) iterations) / 1e6;
        double speedupRatio = avgColTimeMs / avgRowTimeMs;

        System.out.println("=== CPU CACHE LOCALITY BENCHMARK LOGS ===");
        System.out.println("Average Row-Major Time: " + String.format("%.3f", avgRowTimeMs) + " ms");
        System.out.println("Average Column-Major Time: " + String.format("%.3f", avgColTimeMs) + " ms");
        System.out.println("Speedup Ratio (Row-Major vs Column-Major): " + String.format("%.2f", speedupRatio) + "x");
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log
