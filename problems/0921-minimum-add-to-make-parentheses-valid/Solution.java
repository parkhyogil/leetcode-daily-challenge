class Solution {
    public int minAddToMakeValid(String s) {
        int result = 0;
        int b = 0;

        for (char c : s.toCharArray()) {
            if (c == ')') {
                b--;
            } else {
                if (b < 0) {
                    result -= b;
                    b = 0;
                }
                b++;
            }
        }
        
        return result + Math.abs(b);
    }
}
