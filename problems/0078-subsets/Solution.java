class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        recur(0, nums, new ArrayList<>(), res);

        return res;
    }

    private void recur(int idx, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));
        
        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            recur(i + 1, nums, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
