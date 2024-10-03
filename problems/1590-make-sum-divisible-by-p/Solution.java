class Solution {
    public int minSubarray(int[] nums, int p) {
        if (p == 1) {
            return 0;
        }

        int n = nums.length;

        int[] prefixSumRemainders = calculatePrefixSumRemainders(n, nums, p);

        int totalSumRemainder = prefixSumRemainders[n - 1];

        if (totalSumRemainder == 0) {
            return 0;
        }

        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0, -1);

        int lengthMinSubarray = n;
        for (int i = 0; i < n; i++) {
            int targetRemainder = (prefixSumRemainders[i] - totalSumRemainder + p) % p;

            if (remainderIndexMap.containsKey(targetRemainder)) {
                lengthMinSubarray = Math.min(lengthMinSubarray, i - remainderIndexMap.get(targetRemainder));
            }

            remainderIndexMap.put(prefixSumRemainders[i], i);
        }

        return lengthMinSubarray == n ? -1 : lengthMinSubarray;
    }

    private int[] calculatePrefixSumRemainders(int n, int[] nums, int p) {
        int[] prefixSumRemainders = new int[n];
        prefixSumRemainders[0] = nums[0] % p;

        for (int i = 1; i < n; i++) {
            prefixSumRemainders[i] = (prefixSumRemainders[i - 1] + nums[i]) % p;
        }

        return prefixSumRemainders;
    }
}
