class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        
        int result = 0;

        int i = 1;
        while (i <= n) {
            if ((i & n) == 0) {
                result |= i;
            }
            i <<= 1;
        }

        return result;
    }
}
