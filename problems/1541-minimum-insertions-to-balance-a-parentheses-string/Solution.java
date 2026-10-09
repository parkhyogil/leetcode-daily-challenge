class Solution {
    public int minInsertions(String s) {
        int result = 0;

        int b = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (b < 0) {
                    int x = -b;
                    result += (x + 1) / 2 + x % 2;
                    b = 0;
                } else if (b % 2 == 1) {
                    result++;
                    b--;
                }
                b += 2;
            } else {
                b--;
            }
        }

        if (b < 0) {
            int x = -b;
            result += (x + 1) / 2 + x % 2;
        } else {
            result += b;
        }

        return result;
    }
}
