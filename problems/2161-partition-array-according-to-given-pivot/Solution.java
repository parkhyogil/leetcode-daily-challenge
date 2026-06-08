class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int less = 0;
        int equal = 0;

        for (int x : nums) {
            if (x < pivot) {
                less++;
            } else if (x == pivot) {
                equal++;
            }
        }

        int[] result = new int[n];
        int i = 0;
        int j = less;
        int k = less + equal;

        for (int x : nums) {
            if (x < pivot) {
                result[i++] = x;
            } else if (x == pivot) {
                result[j++] = x;
            } else {
                result[k++] = x;
            }
        }

        return result;
    }
}
