class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] result = new int[n];

        int rightBalls = 0;
        int leftBalls = 0;

        if (boxes.charAt(0) == '1') {
            leftBalls++;
        }

        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                rightBalls++;
                result[0] += i;
            }
        }

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] - rightBalls + leftBalls;

            if (boxes.charAt(i) == '1') {
                leftBalls++;
                rightBalls--;
            }
        }

        return result;
    }
}
