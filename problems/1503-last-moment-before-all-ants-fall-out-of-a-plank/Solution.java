class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;

        for (int a : left) {
            res = Math.max(res, a);
        }

        for (int a : right) {
            res = Math.max(res, n - a);
        }

        return res;
    }
}
