class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();

        if (n < k) {
            return false;
        }

        if (n == k) {
            return true;
        }

        int[] frequency = new int[26];

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        int oddNums = 0;

        for (int freq : frequency) {
            if (freq % 2 == 1) {
                oddNums++;
            }
        }

        return oddNums <= k;
    }
}
