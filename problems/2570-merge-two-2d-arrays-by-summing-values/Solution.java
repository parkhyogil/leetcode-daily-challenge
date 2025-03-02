class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        List<int[]> mergedList = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (nums1[i][0] < nums2[j][0]) {
                mergedList.add(nums1[i++]);
            } else if (nums1[i][0] > nums2[j][0]) {
                mergedList.add(nums2[j++]);
            } else {
                mergedList.add(new int[] {nums1[i][0], nums1[i][1] + nums2[j][1]}); 
                i++;
                j++;
            }
        }

        while (i < m) {
            mergedList.add(nums1[i++]);
        }

        while (j < n) {
            mergedList.add(nums2[j++]);
        }

        return mergedList.toArray(new int[0][]);
    }
}
