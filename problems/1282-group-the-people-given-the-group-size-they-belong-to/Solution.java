class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;

        int[] idx = new int[n + 1];
        Arrays.fill(idx, -1);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int size = groupSizes[i];

            if (idx[size] == -1) {
                idx[size] = res.size();
                res.add(new ArrayList<>());
            }

            res.get(idx[size]).add(i);

            if (res.get(idx[size]).size() == size) {
                idx[size] = -1;
            }
        }
        return res;
    }
}
