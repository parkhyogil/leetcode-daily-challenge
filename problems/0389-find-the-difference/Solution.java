class Solution {
    public char findTheDifference(String s, String t) {
        int res = 0;

        for (char c : s.toCharArray()) {
            res ^= (int) c;
        }

        for (char c : t.toCharArray()) {
            res ^= (int) c;
        }

        return (char) res;
    }
}
