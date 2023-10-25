class Solution {
    public int kthGrammar(int n, int k) {
        return recur(k - 1);
    }

    private int recur(int k) {
        if (k == 0) {
            return 0;
        }

        if (k % 2 == 0) {
            return recur(k / 2);
        }
        return recur(k / 2) ^ 1;
    }
}
