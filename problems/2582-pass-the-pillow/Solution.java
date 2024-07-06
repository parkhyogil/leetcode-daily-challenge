class Solution {
    public int passThePillow(int n, int time) {
        int direction = time / (n - 1) % 2;
        int position = time % (n - 1);

        if (direction == 0) {
            return 1 + position;
        } else {
            return n - position;
        }
    }
}
