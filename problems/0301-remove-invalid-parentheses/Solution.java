class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();

        int b = 0;
        int d = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (b < 0) {
                    d -= b;
                    b = 0;
                }
                b++;
            } else if (c == ')') {
                b--;
            }
        }

        d += Math.abs(b);

        char[] arr = new char[n];

        Set<String> result = new HashSet<>();

        recur(0, 0, 0, d, arr, s, result);

        return new ArrayList<>(result);
    }

    void recur(int i, int j, int b, int d, char[] arr, String s, Set<String> result) {
        if (b < 0 || d < 0) {
            return;
        }

        if (i == s.length()) {
            if (b == 0) {
                result.add(String.valueOf(arr, 0, j));
            }
            return;
        }

        char c = s.charAt(i);

        if (c == '(') {
            recur(i + 1, j, b, d - 1, arr, s, result);
            arr[j] = c;
            recur(i + 1, j + 1, b + 1, d, arr, s, result);
        } else if (c == ')') {
            recur(i + 1, j, b, d - 1, arr, s, result);
            arr[j] = c;
            recur(i + 1, j + 1, b - 1, d, arr, s, result);
        } else {
            arr[j] = c;
            recur(i + 1, j + 1, b, d, arr, s, result);
        }
    }
}
