class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;

        boolean[] contains = new boolean[n];

        int[] result = new int[2];
        int i = 0;
        for (int num : nums) {
            if (contains[num]) {
                result[i++] = num;
            } else {
                contains[num] = true;
            }
        }

        return result;
    }
}
