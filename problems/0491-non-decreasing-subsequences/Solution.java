class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, Integer.MIN_VALUE, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int idx, int last, int[] nums, List<Integer> subseq, List<List<Integer>> res) {
        if (idx == nums.length) {
            if (subseq.size() >= 2) {
                res.add(new ArrayList<>(subseq));
            }
            return;
        }

        if (nums[idx] >= last) {
            subseq.add(nums[idx]);
            backtrack(idx + 1, nums[idx], nums, subseq, res);
            subseq.remove(subseq.size() - 1);
        }
        if (nums[idx] != last) {
            backtrack(idx + 1, last, nums, subseq, res);
        }
    }
}
