class Solution {
    public int maxDepth(String s) {
        int d = 0;
        int max = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                d++;
            } else if (c == ')') {
                d--;
            }

            max = Math.max(max, d);
        }

        return max;
    }
}
