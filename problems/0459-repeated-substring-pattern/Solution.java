class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String sub = s.substring(0, i);
                
                if (s.equals(sub.repeat(n / i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
