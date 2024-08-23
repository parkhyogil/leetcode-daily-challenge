class Solution {
    private int n, idx;
    private String expression;

    public String fractionAddition(String expression) {
        this.n = expression.length();
        this.idx = 0;
        this.expression = expression;

        int prevNumerator = 0;
        int prevDenominator = 1;

        while (idx < n) {
            int sign = getSign();

            int numerator = getNumber();
            idx++;
            int denominator = getNumber();

            prevNumerator = prevNumerator * denominator + sign * numerator * prevDenominator;
            prevDenominator *= denominator;
        }

        int gcd = getGCD(Math.abs(prevNumerator), prevDenominator);

        prevNumerator /= gcd;
        prevDenominator /= gcd;

        return prevNumerator + "/" + prevDenominator;
    }

    private int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }

    private int getNumber() {
        int result = 0;

        while (idx < n && Character.isDigit(expression.charAt(idx))) {
            result = result * 10 + expression.charAt(idx) - '0';
            idx++;
        }

        return result;
    }

    private int getSign() {
        char c = expression.charAt(idx);

        if (Character.isDigit(c)) {
            return 1;
        }

        idx++;

        return c == '-' ? -1 : 1;
    }
}
