class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int restDays = n % 7;

        int begin = weeks * (weeks + 1) / 2;

        int res = 7 * (2 * begin + 6 * weeks) / 2;

        res += restDays * (2 * (weeks + 1) + (restDays - 1) * 1) / 2;

        return res;
    }
}
