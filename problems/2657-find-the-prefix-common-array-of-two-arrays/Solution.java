class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] result = new int[n];
        
        long a = 0;
        long b = 0;
        
        for (int i = 0; i < n; i++) {
            a |= 1L << A[i];
            b |= 1L << B[i];
            
            result[i] = Long.bitCount(a & b);
        }
        
        return result;
    }
}
