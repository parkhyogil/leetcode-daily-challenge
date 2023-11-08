class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx - fx);
        int height = Math.abs(sy - fy);

        if (width == 0 && height == 0) {
            return t != 1;
        }

        return t >= Math.max(width, height);
    }
}
