class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] count = new int[n];
        Arrays.fill(count, n);

        Queue<Integer> queue = new ArrayDeque<>();

        if (n > 1 && ratings[0] <= ratings[1]) {
            queue.offer(0);
            count[0] = 1;
        }

        if (n > 1 && ratings[n - 1] <= ratings[n - 2]) {
            queue.offer(n - 1);
            count[n - 1] = 1;
        }

        for (int i = 1; i < n - 1; i++) {
            if (ratings[i - 1] >= ratings[i] && ratings[i] <= ratings[i + 1]) {
                queue.offer(i);
                count[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();

            if (i - 1 >= 0 && ratings[i] < ratings[i - 1]) {
                queue.offer(i - 1);
                count[i - 1] = count[i] + 1;
            }

            if (i + 1 < n && ratings[i] < ratings[i + 1]) {
                queue.offer(i + 1);
                count[i + 1] = count[i] + 1;
            }
        }

        int sum = 0;

        for (int c : count) {
            sum += c;
        }

        return sum;
    }
}
