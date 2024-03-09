class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        for (int i = 0, j = 0; i < m && j < n;) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                return nums1[i];
            }
        }

        return -1;
    }
}
