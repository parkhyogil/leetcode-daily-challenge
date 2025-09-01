class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            double bb = (double) (b[0] + 1) / (b[1] + 1) - (double) b[0] / b[1];
            double aa = (double) (a[0] + 1) / (a[1] + 1) - (double) a[0] / a[1];
            return Double.compare(bb, aa);
        });

        for (int[] c : classes) {
            queue.offer(c);
        }

        while (extraStudents-- > 0) {
            int[] c = queue.poll();
            c[0]++;
            c[1]++;
            queue.offer(c);
        }

        double sum = 0;

        while (!queue.isEmpty()) {
            int[] c = queue.poll();

            sum += (double) c[0] / c[1];
        }

        return sum / classes.length;
    }
}
