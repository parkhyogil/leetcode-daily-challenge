class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            row[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                row[j] = triangle.get(i).get(j) + Math.min(row[j], row[j + 1]);
            }
        }

        return row[0];
    }
}
