class Solution {
    public int[] closestPrimes(int left, int right) {
        if (left <= 2 && right >= 3) {
            return new int[] {2, 3};
        }

        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int num1 = -1;
        int num2 = -1;

        for (int i = 1; i < primes.size(); i++) {
            int a = primes.get(i - 1);
            int b = primes.get(i);

            if (num1 == -1 || num2 - num1 > b - a) {
                num1 = a;
                num2 = b;
            }
        }

        return new int[] {num1, num2};
    }
}
