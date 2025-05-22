class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        Arrays.sort(queries, (a, b) -> a[0] - b[0]);

        int result = queries.length;

        int[] prefixSum = new int[n + 1];
        int sum = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.offer(-1);

        for (int i = 0, j = 0; i < n; i++) {
            while (j < m && queries[j][0] == i) {
                queue.offer(queries[j++][1]);
            }

            sum += prefixSum[i];

            while (!queue.isEmpty() && sum < nums[i]) {
                int r = queue.poll();

                if (r < i) {
                    return -1;
                }

                sum++;
                prefixSum[r + 1]--;
                result--;
            }
        }

        return result;
    }
}
