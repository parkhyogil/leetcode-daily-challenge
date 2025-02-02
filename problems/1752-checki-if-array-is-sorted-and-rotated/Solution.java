class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int begin = 1;

        while (begin < n && nums[begin - 1] <= nums[(begin) % n]) {
            begin++;
        }

        if (begin == n) {
            return true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[(begin + i) % n] > nums[(begin + i + 1) % n]) {
                return false;
            }
        }

        return true;
    }
}
