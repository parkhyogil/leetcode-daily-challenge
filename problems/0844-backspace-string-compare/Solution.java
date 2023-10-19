class Solution {
    public boolean backspaceCompare(String s, String t) {
        return deleteBackspace(s).equals(deleteBackspace(t));
    }

    private String deleteBackspace(String s) {
        char[] chars = s.toCharArray();
        int i = -1;

        for (int j = 0; j < chars.length; j++) {
            if (Character.isLetter(chars[j])) {
                chars[++i] = chars[j];
            } else if (i > -1) {
                i--;
            }
        }

        return String.valueOf(chars, 0, i + 1);
    }
}
