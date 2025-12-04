class Solution {
    public int countCollisions(String directions) {
        int result = 0;

        int toRight = 0;
        int stay = 0;

        for (char c : directions.toCharArray()) {
            if (c == 'L') {
                if (toRight > 0) {
                    result += 2 + toRight - 1;
                    toRight = 0;
                    stay = 1;
                } else if (stay > 0) {
                    result++;
                }
            } else if (c == 'R') {
                toRight++;
                stay = 0;
            } else {
                result += toRight;
                toRight = 0;
                stay = 1;
            }
        }

        return result;
    }
}
