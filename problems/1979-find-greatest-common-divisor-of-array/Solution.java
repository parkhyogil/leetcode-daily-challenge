class Solution {
    public int findGCD(int[] nums) {
        int min = 1001;
        int max = 0;

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        for (int i = min; i > 0; i--) {
            if (max % i == 0 && min % i == 0) {
                return i;
            }
        }

        return -1;
    }
}
