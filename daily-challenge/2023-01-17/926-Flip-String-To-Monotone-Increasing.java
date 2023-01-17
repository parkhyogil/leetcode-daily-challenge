class Solution {
    public int minFlipsMonoIncr(String s) {
        int toZero = 0;
        int toOne = 0;

        for (char c : s.toCharArray()) {
            toOne = Math.min(toZero, toOne);
            if (c == '0') {
                toOne += 1;
            } else {
                toZero += 1;
            }
        }
        return Math.min(toZero, toOne);
    }
}
