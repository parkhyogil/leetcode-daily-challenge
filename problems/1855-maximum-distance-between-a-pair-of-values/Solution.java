class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int result = 0;

        int i = 0;
        for (int j = 0; j < m; j++) {
            while (i < n && nums1[i] > nums2[j]) {
                i++;
            }

            if (i < n && i <= j && nums1[i] <= nums2[j]) {
                result = Math.max(result, j - i);
            }
        }

        return result;
    }
}
