class Solution {
    public int sumFourDivisors(int[] nums) {
        int[] primeDiv = new int[100001];
        for (int i = 2; i * i <= 100000; i++) {
            if (primeDiv[i] != 0) {
                continue;
            }

            for (int j = i * i; j <= 100000; j += i) {
                primeDiv[j] = i;
            }
        }

        int result = 0;

        for (int num : nums) {
            if (primeDiv[num] == 0) {
                continue;
            }

            int x = primeDiv[num];
            int y = num / x;

            if (x * x * x == num || (primeDiv[y] == 0 && x != y && x * y == num)) {
                result += num + 1 + x + y;
            }
        }

        return result;
    }
}
