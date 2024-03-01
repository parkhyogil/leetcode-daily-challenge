class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();

        char[] chars = s.toCharArray();

        int j = -1;

        for (int i = 0; i < n; i++) {
            if (chars[i] == '1') {
                swap(i, ++j, chars);
            }
        }

        swap(j, n - 1, chars);

        return String.valueOf(chars);
    }

    private void swap(int i, int j, char[] chars) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp; 
    }
}
