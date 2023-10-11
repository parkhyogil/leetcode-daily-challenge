class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int m = people.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1] + 1;          
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = binarySearch(start, people[i]) - binarySearch(end, people[i]);
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
