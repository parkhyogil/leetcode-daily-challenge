class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIndegree = new boolean[n];
        for (List<Integer> e : edges) {
            hasIndegree[e.get(1)] = true;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasIndegree[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
