class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexList.add(i);
        }

        indexList.sort((a, b) -> Integer.compare(nums[a], nums[b]));

        PriorityQueue<Integer> highestIndex = new PriorityQueue<>(Collections.reverseOrder());
        highestIndex.offer(indexList.get(0));

        int[] result = new int[n];

        for (int i = 1; i < n; i++) {
            if (nums[indexList.get(i)] - nums[indexList.get(i - 1)] > limit) {
                for (int j = i - 1; !highestIndex.isEmpty(); j--) {
                    result[highestIndex.poll()] = nums[indexList.get(j)];
                }
            }
            highestIndex.offer(indexList.get(i));
        }

        for (int j = n - 1; !highestIndex.isEmpty(); j--) {
            result[highestIndex.poll()] = nums[indexList.get(j)];
        }

        return result;
    }
}
