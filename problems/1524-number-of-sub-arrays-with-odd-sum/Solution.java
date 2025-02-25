class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int numOfSubarrays(int[] arr) {
        int result = 0;

        int odd = 0;
        int even = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                even++;
            } else {
                int nextOdd = even + 1;
                even = odd;
                odd = nextOdd;
            }

            result = (result + odd) % MOD;
        }

        return result;
    }
}
