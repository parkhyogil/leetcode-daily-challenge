class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        backtracking(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private void backtracking(int idx, int[] candidates, int target, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int candidate = candidates[i];

            if ((i > idx && candidate == candidates[i - 1]) || target - candidate < 0) {
                continue;
            }
            
            comb.add(candidate);
            backtracking(i + 1, candidates, target - candidate, comb, result);
            comb.remove(comb.size() - 1);
        }
    }
}
