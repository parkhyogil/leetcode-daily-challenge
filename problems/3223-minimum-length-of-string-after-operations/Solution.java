class Solution {
    public int minimumLength(String s) {
        int result = s.length();
        int[] frequency = new int[26];

        for (char c : s.toCharArray()) {
            int i = c - 'a';
            frequency[i]++;

            if (frequency[i] > 2) {
                frequency[i] -= 2;
                result -= 2;
            }
        }

        return result;
    }
}
