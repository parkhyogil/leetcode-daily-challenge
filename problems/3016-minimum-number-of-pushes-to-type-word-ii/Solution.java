class Solution {
    public int minimumPushes(String word) {
        int[] numberOfLetters = new int[26];

        for (char c : word.toCharArray()) {
            numberOfLetters[c - 'a']++;
        }

        Arrays.sort(numberOfLetters);

        int push = 1;
        int unmappedButtons = 8;

        int result = 0;

        for (int i = 25; i >= 0 && numberOfLetters[i] > 0; i--) {
            if (unmappedButtons == 0) {
                push++;
                unmappedButtons = 8;
            }

            result += push * numberOfLetters[i];
            unmappedButtons--;
        }

        return result;
    }
}
