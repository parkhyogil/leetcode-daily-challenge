class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();

        int[] totalNumOfChars = new int[3];

        for (char c : s.toCharArray()) {
            totalNumOfChars[c - 'a']++;
        }

        for (int num : totalNumOfChars) {
            if (num < k) {
                return -1;
            }
        }

        int minMinute = n;
        int[] numOfCharsInWindow = new int[3];
        for (int l = 0, r = 0; r < n; r++) {
            numOfCharsInWindow[s.charAt(r) - 'a']++;

            while (totalNumOfChars[0] - numOfCharsInWindow[0] < k || totalNumOfChars[1] - numOfCharsInWindow[1] < k || totalNumOfChars[2] - numOfCharsInWindow[2] < k) {
                numOfCharsInWindow[s.charAt(l++) - 'a']--;
            }

            minMinute = Math.min(minMinute, n - (r - l + 1));
        }

        return minMinute;
    }
}
