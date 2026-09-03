class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        Arrays.sort(nums1);

        boolean o = nums1[0] % 2 == 1;

        for (int i = 1; i < n; i++) {
            int p = nums1[i] % 2;
            if (p == nums1[0] % 2) {
                continue;
            }

            if (!o) {
                return false;
            }

            o |= p == 1;
        }

        return true;
    }
}
