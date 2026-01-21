class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            if (x == 2) {
                result[i] = -1;
            } else {
                int j = 1;

                while ((x & j) > 0) {
                    j <<= 1;
                }

                result[i] = x - j / 2;
            }
        }

        return result;
    }
}
