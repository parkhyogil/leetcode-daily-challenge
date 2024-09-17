class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        countWord(s1.split(" "), wordCountMap);
        countWord(s2.split(" "), wordCountMap);

        List<String> uncommonWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }

        return uncommonWords.toArray(new String[0]);
    }

    private void countWord(String[] words, Map<String, Integer> wordCountMap) {
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
    }
}
