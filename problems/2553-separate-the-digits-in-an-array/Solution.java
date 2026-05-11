class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;

        int m = 0;

        for (int x : nums) {
            if (x == 0) {
                m++;
            } else {
                while (x > 0) {
                    m++;
                    x /= 10;
                }
            }
        }

        int[] result = new int[m];

        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];

            while (x > 0) {
                result[--m] = x % 10;
                x /= 10;
            }
        }

        return result;
    }
}
