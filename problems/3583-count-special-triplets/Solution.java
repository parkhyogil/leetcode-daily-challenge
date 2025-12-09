class Solution {
    public int specialTriplets(int[] nums) {
        int max = 100000;

        int[] total = new int[max + 1];
        for (int num : nums) {
            total[num]++;
        }

        long result = 0;

        int[] left = new int[max + 1];

        for (int num : nums) {
            left[num]++;
            int t = num * 2;

            if (t > max) {
                continue;
            }

            if (num == 0) {
                result += (long) (left[0] - 1) * (total[0] - left[0]);
            } else {
                result += (long) left[t] * (total[t] - left[t]);
            }
        }

        return (int) (result % 1_000_000_007);
    }
}
