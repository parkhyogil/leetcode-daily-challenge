class Solution {
    public int maxOperations(String s) {
        int n = s.length();

        int result = 0;

        int ones = 0;
        boolean containsZero = false;

        for (int i = 0; i <= n; i++) {
            if (i == n || s.charAt(i) == '1') {
                if (containsZero) {
                    result += ones;
                    containsZero = false;
                }
                ones++;
            } else {
                containsZero = true;
            }
        }

        return result;
    }
}
