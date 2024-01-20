class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int) 1e9 + 7;

        int[] prevMin = new int[n];
        int[] sum = new int[n];

        Arrays.fill(prevMin, -1);

        int res = 0;

        for (int i = 0; i < n; i++) {
            int prevMinIdx = i - 1;

            while (prevMinIdx != -1 && arr[prevMinIdx] > arr[i]) {
                prevMinIdx = prevMin[prevMinIdx];
            }

            prevMin[i] = prevMinIdx;

            if (prevMinIdx == -1) {
                sum[i] = arr[i] * (i + 1) % mod;
            } else {
                sum[i] = (arr[i] * (i - prevMinIdx) % mod + sum[prevMinIdx]) % mod;
            }

            res = (res + sum[i]) % mod;
        }

        return res;
    }
}
