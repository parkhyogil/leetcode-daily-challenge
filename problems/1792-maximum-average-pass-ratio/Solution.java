class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>(
                (a, b) -> Double.compare(b[0], a[0])
        );

        for (int[] clazz : classes) {
            int pass = clazz[0];
            int total = clazz[1];
            priorityQueue.offer(new double[] {getGain(pass, total), pass, total});
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] clazz = priorityQueue.poll();

            int pass = (int) clazz[1] + 1;
            int total = (int) clazz[2] + 1;

            priorityQueue.offer(new double[] {getGain(pass, total), pass, total});
        }

        double sum = 0L;

        while (!priorityQueue.isEmpty()) {
            double[] clazz = priorityQueue.poll();
            sum += clazz[1] / clazz[2];
        }

        return sum / n;
    }

    private static double getGain(int pass, int total) {
        return (double) (pass + 1) / (total + 1) - (double) pass / total;
    }
}
