class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int result = 0;

        for (int i = 0; i < 26 && freq[25 - i] > 0; i++) {
            result += freq[25 - i] * (i / 8 + 1);
        }

        return result;
    }
}
