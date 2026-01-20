class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            result[i] = -1;

            for (int j = 1; j < x; j++) {
                if ((j | (j + 1)) == x) {
                    result[i] = j;
                    break;
                }
            }
        }

        return result;
    }
}
