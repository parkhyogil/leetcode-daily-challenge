class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int h = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        int w = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);

        return h > 0 && w > 0;
    }
}
