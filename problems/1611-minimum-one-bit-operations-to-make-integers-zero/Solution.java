class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }
        
        int k = 0;

        while ((1 << k) <= n) {
            k++;
        }

        int x = 1;
        
        int res = 0;
        for (int i = 0; i < k; i++) {
            if ((n & (1 << i)) > 0) {
                res = x - res;
            }
            x = x * 2 + 1;
        }
        return res;         
    }
}
