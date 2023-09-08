class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        res.add(Arrays.asList(1));

        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = res.get(i - 2);

            row.add(1);
            for (int j = 0; j < prevRow.size() - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            row.add(1);
            res.add(row);
        }

        return res;
    }
}
