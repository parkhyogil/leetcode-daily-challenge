class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length;

        Arrays.sort(arr);

        Map<Integer, Long> dp = new HashMap<>();

        int res = 0;
        for (int root = 0; root < n; root++) {
            long count = 1;

            for (int child = 0; child < root; child++) {
                if (arr[root] % arr[child] != 0 || !dp.containsKey(arr[root] / arr[child])) {
                    continue;
                }

                count += dp.get(arr[child]) * dp.get(arr[root] / arr[child]);
            }

            count %= mod;

            dp.put(arr[root], count);
            res = (res + (int) count) % mod;
        }

        return res;
    }
}
