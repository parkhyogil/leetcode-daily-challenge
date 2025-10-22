class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 0);

        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        List<Integer> val = new ArrayList<>(freq.keySet());
        val.sort((a, b) -> a - b);

        int m = val.size();

        List<Integer> sum = new ArrayList<>();
        sum.add(0);

        for (int i = 1; i < m; i++) {
            sum.add(sum.get(i - 1) + freq.get(val.get(i)));
        }

        int result = 0;

        for (int i = 1, l = 1, r = 1; i < m; i++) {
            while (r < m && val.get(r) - val.get(i) <= k) {
                r++;
            }
            while (val.get(i) - val.get(l) > k) {
                l++;
            }

            result = Math.max(result, Math.min(freq.get(val.get(i)) + numOperations, sum.get(r - 1) - sum.get(l - 1)));
        }

        for (int l = 1, r = 1; r < m; r++) {
            while (val.get(r) - val.get(l) > k * 2) {
                l++;
            }

            result = Math.max(result, Math.min(numOperations, sum.get(r) - sum.get(l - 1)));
        }

        return result;
    }
}
