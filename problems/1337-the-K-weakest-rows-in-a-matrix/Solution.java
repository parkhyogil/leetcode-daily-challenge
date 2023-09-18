class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[] weakness = new int[m];
        for (int i = 0; i < m; i++) {
            weakness[i] = binarySearch(0, n - 1, mat[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> 
            weakness[a] == weakness[b] ? Integer.compare(b, a) : Integer.compare(weakness[b], weakness[a])
        );

        for (int i = 0; i < m; i++) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }

    private int binarySearch(int lo, int hi, int[] nums) {
        if (lo > hi) {
            return lo;
        }

        int mid = (lo + hi) / 2;

        if (nums[mid] == 0) {
            return binarySearch(lo, mid - 1, nums);
        } else {
            return binarySearch(mid + 1, hi, nums);
        }
    }
}
