class Solution {
    public String decodeAtIndex(String s, int k) {
        long length = 0;

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                length++;
            } else {
                length *= (c - '0');
            }
        }

        k--;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                if (length - 1 == k) {
                    return String.valueOf(c);
                }
                length--;
            } else {
                length /= c - '0';          
                k %= length;
            }
        }

        return null;
    }
}
