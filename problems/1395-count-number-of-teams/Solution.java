class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;

        int res = 0;

        for (int j = 1; j < n - 1; j++) {
            int greater = 0;
            int smaller = 0;

            for (int k = j + 1; k < n; k++) {
                if (rating[k] > rating[j]) {
                    greater++;
                } else {
                    smaller++;
                }
            }

            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    res += greater;
                } else {
                    res += smaller;
                }
            }
        }

        return res;
    }
}
