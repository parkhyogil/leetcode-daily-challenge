class Solution {
    public int totalWaviness(int num1, int num2) {
        int result = 0;

        for (int i = num1; i <= num2; i++) {
            int num = i;

            int a = num % 10;
            num /= 10;
            int b = num % 10;
            num /= 10;

            while (num > 0) {
                int c = num % 10;
                num /= 10;

                if ((a > b && b < c) || (a < b && b > c)) {
                    result++;
                }

                a = b;
                b = c;
            }
        }

        return result;
    }
}
