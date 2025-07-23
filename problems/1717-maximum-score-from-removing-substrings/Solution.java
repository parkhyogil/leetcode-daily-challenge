class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        
        char[] stack = s.toCharArray();
        int j = -1;

        int result = 0;

        for (int i = 0; i < n; i++) {
            char c = stack[i];

            if (x > y && j > -1 && stack[j] == 'a' && c == 'b') {
                result += x;
                j--;
            } else if (x < y && j > -1 && stack[j] == 'b' && c == 'a') {
                result += y;
                j--;
            } else {
                stack[++j] = c;
            }
        }

        n = j + 1;
        j = -1;

        for (int i = 0; i < n; i++) {
            char c = stack[i];

            if (j > -1 && stack[j] == 'a' && c == 'b') {
                result += x;
                j--;
            } else if (j > -1 && stack[j] == 'b' && c == 'a') {
                result += y;
                j--;
            } else {
                stack[++j] = c;
            }
        }

        return result;
    }
}
