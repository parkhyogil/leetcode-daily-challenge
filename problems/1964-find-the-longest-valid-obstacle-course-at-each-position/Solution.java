class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;

        int idx = -1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (idx == -1 || obstacles[i] >= obstacles[idx]) {
                obstacles[++idx] = obstacles[i];
                res[i] = idx + 1;
            } else {
                int pos = binarySearch(obstacles, 0, idx, obstacles[i]);
                obstacles[pos] = obstacles[i];
                res[i] = pos + 1;
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
