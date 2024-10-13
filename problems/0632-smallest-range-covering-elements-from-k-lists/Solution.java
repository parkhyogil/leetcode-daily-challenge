class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        PriorityQueue<int[]> smallestElementsOfLists = new PriorityQueue<>((a, b) -> Integer.compare(nums.get(a[0]).get(a[1]), nums.get(b[0]).get(b[1])));

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            smallestElementsOfLists.offer(new int[] {i, 0});
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }

        int[] range = new int[] {-100000, 100000};

        while (true) {
            int[] pos = smallestElementsOfLists.poll();
            int minValue = nums.get(pos[0]).get(pos[1]);

            if (range[1] - range[0] > maxValue - minValue) {
                range[0] = minValue;
                range[1] = maxValue;
            }

            pos[1]++;

            if (nums.get(pos[0]).size() == pos[1]) {
                break;
            }

            smallestElementsOfLists.offer(pos);
            maxValue = Math.max(maxValue, nums.get(pos[0]).get(pos[1]));
        }

        return range;
    }
}
