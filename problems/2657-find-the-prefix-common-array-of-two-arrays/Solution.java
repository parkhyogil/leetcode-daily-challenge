class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] result = new int[n];

        long x = 0;
        long y = 0;

        for (int i = 0; i < n; i++) {
            x |= 1L << A[i];
            y |= 1L << B[i];

            result[i] = Long.bitCount(x & y);
        }

        return result;
    }
}
