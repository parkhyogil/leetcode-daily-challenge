class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }

        int res = 0;

        for (int l = 0, r = 0; r < n; r++) {
            if (grumpy[r] == 1) {
                sum += customers[r];
            }

            if (r - l + 1 > minutes) {
                if (grumpy[l] == 1) {
                    sum -= customers[l];
                }
                l++;
            }

            res = Math.max(res, sum);
        }

        return res;
    }
}
