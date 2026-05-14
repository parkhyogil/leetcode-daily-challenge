class Solution {
    public boolean isGood(int[] nums) {
        int b = nums.length - 1;

        int[] freq = new int[b + 1];

        for (int x : nums) {
            if (x > b) {
                return false;
            }

            freq[x]++;
            
            if ((x == b && freq[x] > 2) || (x < b && freq[x] > 1)) {
                return false;
            }
        }

        return true;
    }
}
