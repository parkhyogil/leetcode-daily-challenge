class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        
        int[] prefixSum = calculatePrefixSum(words);
        
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = getRangeSum(queries[i][0], queries[i][1], prefixSum);
        }

        return result;
    }

    int[] calculatePrefixSum(String[] words) {
        int n = words.length;

        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i];
            if (isVowelString(words[i])) {
                prefixSum[i + 1]++;
            }
        }

        return prefixSum;
    }

    int getRangeSum(int left, int right, int[] prefixSum) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    boolean isVowelString(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
