class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        boolean containZero1 = false, containZero2 = false;

        for (int num : nums1) {
            if (num == 0) {
                containZero1 = true;
                sum1++;
            }
            sum1 += num;
        }

        for (int num : nums2) {
            if (num == 0) {
                containZero2 = true;
                sum2++;
            }
            sum2 += num;
        }

        if (sum1 == sum2) {
            return sum1;
        } else if (sum1 > sum2) {
            return containZero2 ? sum1 : -1;
        } else {
            return containZero1 ? sum2 : -1;
        }
    }
}
