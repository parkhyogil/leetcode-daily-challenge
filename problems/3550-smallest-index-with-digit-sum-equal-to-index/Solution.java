class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int s = 0;

            while (x > 0) {
                s += x % 10;
                x /= 10;
            }

            if (s == i) {
                return i;
            }
        }

        return -1;
    }
}
