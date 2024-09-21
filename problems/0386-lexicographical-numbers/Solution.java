class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            if (i > n) {
                break;
            }
            
            dfs(0, i, n, result);
        }

        return result;
    }

    private void dfs(int depth, int num, int n, List<Integer> result) {
        result.add(num);

        for (int i = 0; i <= 9; i++) {
            int nextNum = num * 10 + i;

            if (nextNum > n) {
                return;
            }

            dfs(depth + 1, nextNum, n, result);
        }
    }
}
