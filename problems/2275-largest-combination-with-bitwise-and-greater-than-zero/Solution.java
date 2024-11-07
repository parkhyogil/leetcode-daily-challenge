class Solution {
    public int largestCombination(int[] candidates) {
        int[] numOfBits = new int[32];

        for (int candidate : candidates) {
            for (int i = 0; i < 32; i++) {
                if ((candidate & (1 << i)) != 0) {
                    numOfBits[i]++;
                }
            }
        }

        int max = 0;

        for (int num : numOfBits) {
            max = Math.max(max, num);
        }

        return max;
    }
}
