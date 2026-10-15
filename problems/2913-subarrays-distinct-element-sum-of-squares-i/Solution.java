class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();

        int result = 0;

        for (int i = 0; i < n; i++) {
            boolean[] f = new boolean[101];
            int x = 0;

            for (int j = i; j < n; j++) {
                if (!f[nums.get(j)]) {
                    x++;
                }
                f[nums.get(j)] = true;

                result += x * x;
            }
        }

        return result;
    }
}
