class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        recur(0, nums, new ArrayList<>(), new boolean[n], res);

        return res;
    }

    private void recur(int idx, int[] nums, List<Integer> permu, boolean[] used, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(permu));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            permu.add(nums[i]);
            recur(idx + 1, nums, permu, used, res);
            permu.remove(idx);
            used[i] = false;
        }
    }
}
