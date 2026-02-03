class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;

        int p = 0;

        while (p + 1 < n && nums[p] < nums[p + 1]) {
            p++;
        }

        if (p == 0) {
            return false;
        }

        int q = p;

        while (q + 1 < n && nums[q] > nums[q + 1]) {
            q++;
        }

        if (p == q) {
            return false;
        }

        int l = q;

        while (l + 1 < n && nums[l] < nums[l + 1]) {
            l++;
        }

        return q < l && l == n - 1;
    }
}
