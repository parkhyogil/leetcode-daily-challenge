class Solution {
    public int findClosest(int x, int y, int z) {
        int dist = Math.abs(x - z) - Math.abs(y - z);

        return dist == 0 ? 0 : (dist < 0 ? 1 : 2);
    }
}
