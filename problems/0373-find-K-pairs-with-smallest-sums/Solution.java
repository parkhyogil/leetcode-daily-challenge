class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]));

        for (int i = 0; i < m; i++) {
            pq.offer(new int[] {i, 0});   
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty() && k-- > 0) {
            int[] pair = pq.poll();
            res.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));

            if (pair[1] + 1 < n) {
                pair[1]++;
                pq.offer(pair);
            }
        }
        return res;
    }
}
