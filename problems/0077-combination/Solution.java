class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        recur(n, k, res, new ArrayList<>());

        return res;
    }

    private void recur(int n, int k, List<List<Integer>> res, List<Integer> comb) {
        if (k == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = n; i >= k; i--) {
            comb.add(i);
            recur(i - 1, k - 1, res, comb);
            comb.remove(comb.size() - 1);
        }
    }
}
