class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        
        int res = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                res = Math.max(res, depth);
            } else if (c == ')') {
                depth--;
            }
        }

        return res;
    }
}
