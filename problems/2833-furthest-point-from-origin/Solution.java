class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int diff = 0;
        int count = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                diff++;
            } else if (c == 'L') {
                diff--;
            } else {
                count++;
            }
        }

        return Math.abs(diff) + count;
    }
}
