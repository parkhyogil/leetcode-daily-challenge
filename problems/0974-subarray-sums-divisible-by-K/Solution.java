class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;

        int[] count = new int[k];
        count[0] = 1;

        int remainder = 0;

        for (int num : nums) {
            remainder = (remainder + num) % k;
            if (remainder < 0) {
                remainder += k;
            }

            res += count[remainder];

            count[remainder]++;
        }

        return res;
    }
}
