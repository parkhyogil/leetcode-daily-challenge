class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] ascSequence = new int[n];
        int[] descSequence = new int[n];

        List<Integer> LIS = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (LIS.isEmpty() || LIS.get(LIS.size() - 1) < nums[i]) {
                LIS.add(nums[i]);
                ascSequence[i] = LIS.size();
            } else {
                int index = binarySearch(nums[i], LIS);
                LIS.set(index, nums[i]);
                ascSequence[i] = index + 1;
            } 
        }
        
        LIS.clear();
        
        for (int i = n - 1; i >= 0; i--) {
            if (LIS.isEmpty() || LIS.get(LIS.size() - 1) < nums[i]) {
                LIS.add(nums[i]);
                descSequence[i] = LIS.size();
            } else {
                int index = binarySearch(nums[i], LIS);
                LIS.set(index, nums[i]);
                descSequence[i] = index + 1;
            }
        }

        int removals = n;

        for (int i = 1; i < n - 1; i++) {
            if (ascSequence[i] > 1 && descSequence[i] > 1) {
                removals = Math.min(removals, n - (ascSequence[i] + descSequence[i] - 1));
            }
        }

        return removals;
    }

    int binarySearch(int target, List<Integer> list) {
        int lo = 0;
        int hi = list.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid) >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
}
