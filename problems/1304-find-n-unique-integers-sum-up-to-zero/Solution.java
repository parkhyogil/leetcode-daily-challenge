class Solution {
    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[] {0};
        }

        int[] result = new int[n];

        for (int i = 1; i < n; i++) {
            result[i] = i;
            result[0] -= i;
        }

        return result;
    }
}
