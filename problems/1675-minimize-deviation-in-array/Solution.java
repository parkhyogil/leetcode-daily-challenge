class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;

        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < n; i++) {
            int curVal = nums[i];
            while (curVal % 2 == 0) {
                curVal /= 2;
            }
            int maxVal = nums[i] % 2 == 0 ? nums[i] : nums[i] * 2;
            set.add(new int[] {curVal, maxVal});
        }

        int res = Integer.MAX_VALUE;
        while (true) {
            int[] first = set.first();
            res = Math.min(res, set.last()[0] - first[0]);
            set.remove(first);
            first[0] *= 2;
            if (first[0] > first[1]) {
                break;
            }
            set.add(first);
        }
        return res;
    }
}
