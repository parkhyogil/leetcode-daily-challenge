class Solution {
    public int numSub(String s) {
        long result = 0;
        int ones = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                result += ++ones;
            } else {
                ones = 0;
            }
        }

        return (int) (result % 1000000007);
    }
}
