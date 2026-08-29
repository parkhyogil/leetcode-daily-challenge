class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idx.add(i);
        }

        idx.sort((a, b) -> nums[a] - nums[b]);

        int[] id = new int[n];
        int[] start = new int[n];

        for (int i = 1; i < n; i++) {
            int a = idx.get(i);
            int b = idx.get(i - 1);

            id[a] = id[b];
            if (nums[a] - nums[b] > limit) {
                id[a]++;
                start[id[a]] = i;
            }
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = nums[idx.get(start[id[i]]++)];
        }

        return result;
    }
}
