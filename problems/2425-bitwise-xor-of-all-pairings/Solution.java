class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int result = 0;

        if (n % 2 == 1) {
            result ^= doXorAllValues(nums1);
        }

        if (m % 2 == 1) {
            result ^= doXorAllValues(nums2);
        }

        return result;
    }

    int doXorAllValues(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
