class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;

        List<Boolean> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            res.add(isArithmeticSubarray(nums, l[i], r[i]));
        }

        return res;
    }

    private boolean isArithmeticSubarray(int[] nums, int l, int r) {
        int min = nums[l];
        int max = nums[l];

        for (int i = l; i <= r; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if (min == max) {
            return true;
        }

        if ((max - min) % (r - l) != 0) {
            return false;
        }

        int diff = (max - min) / (r - l);
        boolean[] visit = new boolean[r - l + 1];

        for (int i = l; i <= r; i++) {
            if ((nums[i] - min) % diff != 0) {
                return false;
            }

            int idx = (nums[i] - min) / diff;
            
            if (visit[idx]) {
                return false;
            }
            visit[idx] = true;
        }   
        return true;     
    }
}
