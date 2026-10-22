class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int x = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[x]) {
                x = i;
            }
        }

        boolean a = true;
        boolean b = true;

        for (int i = 0; i < n - 1; i++) {
            a &= nums[(x + i) % n] < nums[(x + i + 1) % n];
            b &= nums[(x - i + n) % n] < nums[(x - i - 1 + n) % n];
        }

        if (a) {
            return Math.min(x, n - x + 2);
        } 
        if (b) {
            return 1 + Math.min(x + 1, n - 1 - x);
        }
        return -1;
    }
}
