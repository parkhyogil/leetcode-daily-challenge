class Solution {
    public String clearDigits(String s) {
        char[] chars = s.toCharArray();

        int idx = -1;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                idx--;
            } else {
                chars[++idx] = c;
            }
        }

        return String.valueOf(chars, 0, idx + 1);
    }
}
