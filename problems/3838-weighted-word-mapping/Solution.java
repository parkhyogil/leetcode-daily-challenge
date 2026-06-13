class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            int w = 0;
            for (char c : words[i].toCharArray()) {
                w += weights[c - 'a'];
            }
            
            w %= 26;

            result[i] = (char) ('z' - w);
        }

        return String.valueOf(result);
    }
}
