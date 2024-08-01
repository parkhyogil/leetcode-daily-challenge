class Solution {
    public int countSeniors(String[] details) {
        int res = 0;

        for (String detail : details) {
            if (isSenior(detail)) {
                res++;
            }
        }

        return res;
    }

    private boolean isSenior(String detail) {
        return (detail.charAt(11) - '0') * 10 + (detail.charAt(12) - '0') > 60;
    }
}
