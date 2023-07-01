class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        return recur(0, children, cookies);
    }

    private int recur(int idx, int[] children, int[] cookies) {
        if (idx == cookies.length) {
            int max = 0;
            for (int sum : children) {
                max = Math.max(max, sum);
            }
            return max;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < children.length; i++) {
            children[i] += cookies[idx];
            res = Math.min(res, recur(idx + 1, children, cookies));
            children[i] -= cookies[idx];
            if (children[i] == 0) {
                break;
            }
        }
        return res;
    }
}
