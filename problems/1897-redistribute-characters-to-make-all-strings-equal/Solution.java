class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;

        int[] count = new int[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] % n != 0) {
                return false;
            }
        }

        return true;
    }
}
