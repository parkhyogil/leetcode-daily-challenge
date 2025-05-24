class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (words[i].indexOf(x) >= 0) {
                result.add(i);
            }
        }

        return result;
    }
}
