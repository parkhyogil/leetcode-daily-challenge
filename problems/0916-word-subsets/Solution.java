class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        
        int[] frequency = new int[26];

        for (String word : words2) {
            int[] currFrequency = countCharacters(word);

            for (int i = 0; i < 26; i++) {
                frequency[i] = Math.max(frequency[i], currFrequency[i]);
            }
        }

        for (String word : words1) {
            if (isSubset(word, frequency)) {
                result.add(word);
            }
        }

        return result;
    }

    int[] countCharacters(String s) {
        int[] result = new int[26];

        for (char c : s.toCharArray()) {
            result[c - 'a']++;
        }

        return result;
    }

    boolean isSubset(String word, int[] frequency) {
        int[] currFrequency = countCharacters(word);

        for (int i = 0; i < 26; i++) {
            if (currFrequency[i] < frequency[i]) {
                return false;
            }
        }

        return true;
    }
}
