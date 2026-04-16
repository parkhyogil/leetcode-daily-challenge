class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] dist = new int[n];
        int[] prev = new int[max + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        for (int j = 0; j < n * 2; j++) {
            int i = j % n;

            if (prev[nums[i]] != -1) {
                dist[i] = Math.min(dist[i], j - prev[nums[i]]);
                dist[prev[nums[i]] % n] = Math.min(dist[prev[nums[i]] % n], j - prev[nums[i]]);
            }
            prev[nums[i]] = j;
        }

        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            result.add(dist[q] == n ? -1 : dist[q]);
        }

        return result;
    }
}
