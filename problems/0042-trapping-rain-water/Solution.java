class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] stack = new int[n];
        int idx = -1;

        int res = 0;
        for (int i = 0; i < n; i++) {
            while (idx > -1 && height[i] >= height[stack[idx]]) {
                if (idx > 0 && height[i] > height[stack[idx]]) {
                    int h = Math.min(height[i], height[stack[idx - 1]]) - height[stack[idx]];
                    int len = i - stack[idx - 1] - 1;
                    
                    res += h * len;
                }
                idx--;
            }
            stack[++idx] = i;
        }
        return res;
    }
}
