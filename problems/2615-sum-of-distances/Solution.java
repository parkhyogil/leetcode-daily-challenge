class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] result = new long[n];

        for (List<Integer> list : map.values()) {
            int m = list.size();

            long sum = 0;
            for (int i = 1; i < m; i++) {
                int j = list.get(i);
                sum += (long) (j - list.get(i - 1)) * i;
                result[j] = sum;
            }

            sum = 0;
            for (int i = m - 2; i >= 0; i--) {
                int j = list.get(i);
                sum += (long) (list.get(i + 1) - j) * (m - i - 1);
                result[j] += sum;
            }
        }

        return result;
    }
}
