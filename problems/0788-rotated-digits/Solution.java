class Solution {
    public int rotatedDigits(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int j = 0;
            boolean isGood = true;

            for (int k = 1; k <= i; k *= 10) {
                int d = i % (k * 10) / k;

                if (d == 3 || d == 4 || d == 7) {
                    isGood = false;
                    break;
                }

                if (d == 2) {
                    d = 5;
                } else if (d == 5) {
                    d = 2;
                } else if (d == 6) {
                    d = 9;
                } else if (d == 9) {
                    d = 6;
                }
                
                j += d * k;
            }

            if (isGood && j != i) {
                result++;
            }
        }

        return result;
    }
}
