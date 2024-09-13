class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int numQueries = queries.length;

        int[] prefixXOR = buildPrefixXOR(arr);

        int[] result = new int[numQueries];

        for (int i = 0; i < numQueries; i++) {
            result[i] = queryRangeXOR(prefixXOR, queries[i]);
        }

        return result;
    }

    private int queryRangeXOR(int[] prefixXOR, int[] query) {
        int left = query[0];
        int right = query[1];

        return prefixXOR[left] ^ prefixXOR[right + 1];
    }

    private int[] buildPrefixXOR(int[] arr) {
        int length = arr.length;

        int[] prefixXOR = new int[length + 1];

        for (int i = 0; i < length; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }

        return prefixXOR;
    }
}
