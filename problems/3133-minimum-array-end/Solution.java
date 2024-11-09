class Solution {
    public long minEnd(int n, int x) {
        if (n == 1) {
            return x;
        }

        n--;

        int binaryLength = (int) Math.floor(Math.log(x) / Math.log(2)) + 1;

        int oneBits = Integer.bitCount(x);
        int zeroBits = binaryLength - oneBits;

        int possibleWaysRightPart = (int) (Math.pow(2, zeroBits));

        if (possibleWaysRightPart == 0) {
            return ((long) n << binaryLength) + x;
        }

        long result = ((long) (n / possibleWaysRightPart) << binaryLength) + x;

        int rightNum = n % possibleWaysRightPart;

        for (int i = 0; i < binaryLength; i++) {
            if (((1 << i) & x) == 0) {
                result |= (rightNum % 2) << i;
                rightNum /= 2;
            }
        }

        return result;
    }
}
