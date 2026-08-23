class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int lSum = 0;
        int rSum = 0;
        int lq = 0;
        int rq = 0;

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                if (i < n / 2) {
                    lq++;
                } else {
                    rq++;
                }
            } else {
                if (i < n / 2) {
                    lSum += c - '0';
                } else {
                    rSum += c - '0';
                }
            }
        }

        if ((lq + rq) % 2 == 1) {
            return true;
        }

        lSum += lq / 2 * 9;
        rSum += rq / 2 * 9;

        return lSum != rSum;
    }
}
