class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k <= n; k++) {
                if (prefix[i] == prefix[k]) {
                    res += k - i - 1;
                }
            }
        }

        return res;
    }
}
