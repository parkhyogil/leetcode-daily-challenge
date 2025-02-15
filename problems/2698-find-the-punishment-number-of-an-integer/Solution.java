class Solution {
    public int punishmentNumber(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (isNumSatisfied(i * i, i)) {
                result += i * i;
            }
        }

        return result;
    }

    boolean isNumSatisfied(int square, int sum) {
        if (square == sum) {
            return true;
        }

        if (sum <= 0) {
            return false;
        }

        int x = 10;

        while (x <= square) {
            if (isNumSatisfied(square / x, sum - square % x)) {
                return true;
            }
            x *= 10;
        }

        return false;
    }
}
