class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();

        char[] arr = s.toCharArray();

        if (x > y) {
            int len1 = removeSubstring(arr, n, 'a', 'b');
            int len2 = removeSubstring(arr, len1, 'b', 'a');

            return (n - len1) / 2 * x + (len1 - len2) / 2 * y;
        } else {
            int len1 = removeSubstring(arr, n, 'b', 'a');
            int len2 = removeSubstring(arr, len1, 'a', 'b');

            return (n - len1) / 2 * y + (len1 - len2) / 2 * x;
        }
    }

    private int removeSubstring(char[] arr, int len, char a, char b) {
        int idx = -1;

        for (int i = 0; i < len; i++) {
            char c = arr[i];

            if (c == b && idx > -1 && arr[idx] == a) {
                idx--;
            } else {
                arr[++idx] = c;
            }
        }

        return idx + 1;
    }
}
