class Solution {
    public int minFlips(int a, int b, int c) {
        int or = a | b;
        int xor = or ^ c;
        
        int res = 0;
        for (int i = 0; 1 << i <= xor; i++) {
            int bit = 1 << i;

            if ((xor & bit) == 0) {
                continue;
            }

            if ((c & bit) == 0) {
                if ((a & bit) > 0) {
                    res++;
                }
                if ((b & bit) > 0) {
                    res++;
                }
            } else {
                res++;
            }
        }
        return res;
    }
}
