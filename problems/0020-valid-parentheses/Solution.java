class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        int[] a = new int[n];
        int i = -1;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                a[++i] = c;
                continue;
            }

            if (i == -1) {
                return false;
            }

            if ((a[i] == '(' && c != ')') || (a[i] == '[' && c != ']') || (a[i] == '{' && c != '}')) {
                return false;
            }
            i--;
        }

        return i == -1;
    }
}
