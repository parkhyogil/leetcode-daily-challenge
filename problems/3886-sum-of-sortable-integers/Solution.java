class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && isValid(i, n, nums)) {
                result += i;
            }
        }

        return result;
    }

    boolean isValid(int len, int n, int[] nums) {
        int prevMax = -1;

        for (int l = 0; l < n; l += len) {
            int r = l + len - 1;

            if (isSorted(l, r, nums)) {
                if (prevMax > nums[l]) {
                    return false;
                }
                prevMax = nums[r];
            } else {
                int p = l + 1;

                while (nums[p - 1] <= nums[p]) {
                    p++;
                }

                if (!isSorted(p, r, nums) || nums[l] < nums[r] || prevMax > nums[p]) {
                    return false;
                }
                prevMax = nums[p - 1];
            }
        }

        return true;
    }

    boolean isSorted(int l, int r, int[] nums) {
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
