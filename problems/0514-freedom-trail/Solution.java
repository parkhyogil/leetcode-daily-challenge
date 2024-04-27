class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();

        int[][] cache = new int[n][m];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        recur(0, 0, ring, key, cache);
        for(int[] arr : cache) {
            System.out.println(Arrays.toString(arr));
        }
        return cache[0][0];
    }

    private int recur(int ringIdx, int keyIdx, String ring, String key, int[][] cache) {
        if (keyIdx == key.length()) {
            return 0;
        }   

        if (cache[ringIdx][keyIdx] != -1) {
            return cache[ringIdx][keyIdx];
        }

        int len = ring.length();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= len / 2; i++) {
            int right = (ringIdx + i) % len;
            int left = (len + ringIdx - i) % len;

            if (key.charAt(keyIdx) == ring.charAt(right)) {
                res = Math.min(res, 1 + i + recur(right, keyIdx + 1, ring, key, cache));
            }
            if (key.charAt(keyIdx) == ring.charAt(left)) {
                res = Math.min(res, 1 + i + recur(left, keyIdx + 1, ring, key, cache));
            }
        }

        return cache[ringIdx][keyIdx] = res;
    }
}
