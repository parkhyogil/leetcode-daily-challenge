class Solution {
    public int numSteps(String s) {
        int n = s.length();

        int carry = 0;

        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = s.charAt(i) - '0' + carry;

            if (num == 1) {
                if (i == 0) {
                    break;
                }

                num = 2;
                res++;
            }

            carry = num / 2;
            res++;
        }

        return res;
    }
}
