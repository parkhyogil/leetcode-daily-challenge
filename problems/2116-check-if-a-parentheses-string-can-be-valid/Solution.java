class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        if (n % 2 == 1) {
            return false;
        }

        int lockedOpen = 0;

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1' && s.charAt(i) == '(') {
                lockedOpen++;
            }
        }

        if (lockedOpen > n / 2) {
            return false;
        }

        int unlockedOpen = n / 2 - lockedOpen;
        int open = 0;

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0' && unlockedOpen > 0) {
                open++;
                unlockedOpen--;
            } else if (locked.charAt(i) == '1' && s.charAt(i) == '(') {
                open++;
            } else {
                open--;
                if (open < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
