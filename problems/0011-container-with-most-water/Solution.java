class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int result = 0;

        for (int l = 0, r = n - 1; l < r; ) {
            result = Math.max(result, Math.min(height[l], height[r]) * (r - l));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}
