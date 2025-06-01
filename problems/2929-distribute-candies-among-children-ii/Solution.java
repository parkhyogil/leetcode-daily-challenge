class Solution {
    public long distributeCandies(int n, int limit) {
        if (limit >= n) {
            return (long) (n + 2) * (n + 1) / 2;
        }

        long result = 0;

        for (int i = 0; i <= limit; i++) {
            int maxJ = n - i;
            
            result += maxJ + 1;
            
            if (maxJ > limit) {
                result -= Math.min((maxJ - limit) * 2, maxJ + 1); 
            }
        }

        return result;
    }
}
