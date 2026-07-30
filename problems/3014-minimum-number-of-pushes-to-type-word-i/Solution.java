class Solution {
    public int minimumPushes(String word) {
        int n = word.length();

        int result = 0;

        int i = 1;
        
        while (n > 0) {
            result += Math.min(n, 8) * i;
            i++;
            n -= 8;
        }

        return result;
    }
}
