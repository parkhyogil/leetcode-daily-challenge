class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int maximumScore(List<Integer> nums, int k) {
        List<long[]> subarrays = calculateSubarrayInfo(nums);

        subarrays.sort((a, b) -> Long.compare(b[0], a[0]));

        long result = 1L;

        for (int i = 0; i < subarrays.size() && k > 0; i++) {
            long[] info = subarrays.get(i);

            result = result * pow(info[0], Math.min(info[1], k)) % MOD;
            k -= info[1];
        }

        return (int) (result % MOD);
    }

    private long pow(long base, long exponent) {
        long result = 1L;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exponent /= 2;
        }
        return result;
    }

    private List<long[]> calculateSubarrayInfo(List<Integer> nums) {
        int n = nums.size();

        List<long[]> subarrays = new ArrayList<>();
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            int primeScore = getPrimeScore(num);

            while (!stack.isEmpty() && stack.peekLast()[2] < primeScore) {
                int[] prev = stack.removeLast();
                subarrays.add(new long[] {prev[1], (long) (i - prev[0]) * (prev[0] - (stack.isEmpty() ? -1 : stack.peekLast()[0]))});
            }
            stack.addLast(new int[] {i, num, primeScore});
        }

        while (!stack.isEmpty()) {
            int[] prev = stack.removeLast();
            subarrays.add(new long[] {prev[1], (long) (n - prev[0]) * (prev[0] - (stack.isEmpty() ? -1 : stack.peekLast()[0]))});
        }

        return subarrays;
    }

    private int getPrimeScore(int num) {
        if (isPrime(num)) {
            return 1;
        }

        int score = 0;

        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                score++;
                while (num % i == 0) {
                    num /= i;
                }
            }
        }

        return score;
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
