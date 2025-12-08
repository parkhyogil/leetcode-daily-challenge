class Solution {
    public int countTriples(int n) {
        int result = 0;

        for (int a = 1; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                int x = a * a + b * b;
                
                for (int c = (int) Math.sqrt(x); c <= n && c * c <= x; c++) {
                    if (c * c == x) {
                        result += 2;
                    }
                }
            }
        }

        return result;
    }
}
