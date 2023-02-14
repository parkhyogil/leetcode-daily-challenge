class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        
        int p1 = 1, p2 = 1, p3 = 0;
        for (int i = 3; i <= n; i++) {
            int cur = p1 + p2 + p3;
            p3 = p2;
            p2 = p1;
            p1 = cur;
        }
        return p1;
    }
}
