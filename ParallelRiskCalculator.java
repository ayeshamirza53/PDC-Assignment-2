import java.util.concurrent.RecursiveTask;

public class ParallelRiskCalculator extends RecursiveTask<Double> {
    private static final int THRESHOLD = 1000; // Sequential threshold[cite: 9]
    private double[] assets;
    private int start;
    private int end;

    public ParallelRiskCalculator(double[] assets, int start, int end) {
        this.assets = assets;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        if ((end - start) <= THRESHOLD) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                sum += assets[i];
            }
            return sum;
        } else {
            int mid = start + (end - start) / 2;
            ParallelRiskCalculator subTask1 = new ParallelRiskCalculator(assets, start, mid);
            ParallelRiskCalculator subTask2 = new ParallelRiskCalculator(assets, mid, end);

            subTask1.fork();
            double rightResult = subTask2.compute();
            double leftResult = subTask1.join();

            return leftResult + rightResult;
        }
    }
}
// Updated for PDC Lab Assignment 2

// Update commit log
