class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();

        if (n == k) {
            return "0";
        }

        int deleted = 0;

        char[] stack = new char[n];
        int idx = -1;

        for (char c : num.toCharArray()) {
            while (k > deleted && idx >= 0 && stack[idx] > c) {
                idx--;
                deleted++;
            }
            stack[++idx] = c;
        }

        while (k > deleted) {
            idx--;
            deleted++;
        }

        int zeroCount = 0;

        while (zeroCount < n - k && stack[zeroCount] == '0') {
            zeroCount++;
        }

        return zeroCount == n - k ? "0" : String.valueOf(stack, zeroCount, n - k - zeroCount);
    }
}
