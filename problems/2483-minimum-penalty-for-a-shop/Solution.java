class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int res = 0;

        int minPenalty = 0;
        int penalty = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if (minPenalty > penalty) {
                res = i + 1;
                minPenalty = penalty;
            }
        }
        return res;
    }
}
