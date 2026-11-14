class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + nums.get(i);
        }

        int result = -1;

        for (int i = l; i <= r; i++) {
            for (int j = 0; j + i <= n; j++) {
                int sum = p[j + i] - p[j];

                if (sum > 0 && (result == -1 || result > sum)) {
                    result = sum;
                }
            }
        }

        return result;
    }
}
