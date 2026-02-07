class Solution {
    public int minimumDeletions(String s) {
        int result = s.length();

        int prefA = 0;
        int prefB = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                prefA++;
                result = Math.min(result, prefB - prefA);
            } else {
                result = Math.min(result, prefB - prefA);
                prefB++;
            }
        }

        return result + prefA;
    }
}
