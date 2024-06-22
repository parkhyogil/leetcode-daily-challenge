class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        List<Integer> oddIdx = new ArrayList<>();
        oddIdx.add(-1);

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                oddIdx.add(i);
            }
        }
        oddIdx.add(n);

        int res = 0;

        for (int i = 1; i < oddIdx.size() - k; i++) {
            res += (oddIdx.get(i) - oddIdx.get(i - 1)) * (oddIdx.get(i + k) - oddIdx.get(i + k - 1));
        }

        return res;
    }
}
