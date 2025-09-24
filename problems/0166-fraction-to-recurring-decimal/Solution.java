class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator;
        long d = denominator;

        if (n % d == 0) {
            return String.valueOf(n / d);
        }

        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        if (n < 0 ^ d < 0) {
            sb.append('-');
        }
        n = Math.abs(n);
        d = Math.abs(d);

        sb.append(n / d).append('.');
        n = n % d * 10;

        while (n > 0 && !map.containsKey(n)) {
            map.put(n, sb.length());
            sb.append(n / d);
            n = n % d * 10;
        }

        if (n > 0) {
            sb.insert(map.get(n), "(");
            sb.append(')');
        }

        return sb.toString();
    }
}
