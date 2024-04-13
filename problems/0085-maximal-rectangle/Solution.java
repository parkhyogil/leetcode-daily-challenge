class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];

        int res = 0;

        for (char[] row : matrix) {
            for (int c = 0; c < n; c++) {
                if (row[c] == '0') {
                    height[c] = 0;
                } else {
                    height[c]++;
                }
            }

            res = Math.max(res, getMaxArea(height));
        }

        return res;
    }

    private int getMaxArea(int[] height) {
        int n = height.length;

        Stack<Integer> stack = new Stack<>();

        int res = 0;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || height[stack.peek()] > height[i])) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;

                res = Math.max(res, h * w);
            }
            stack.push(i);
        }

        return res;
    }
}
