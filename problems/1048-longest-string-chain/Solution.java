class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> chainCount = new HashMap<>();
        Map<Integer, List<String>> wordsByLength = new HashMap<>();
        for (int l = 1; l <= 16; l++) {
            wordsByLength.put(l, new ArrayList<>());
        }
        for (String word : words) {
            chainCount.put(word, 1);
            wordsByLength.get(word.length()).add(word);
        }
        
        int res = 1;
        for (int l = 1; l <= 15; l++) {
            for (String curr : wordsByLength.get(l)) {
                for (String next : wordsByLength.get(l + 1)) {
                    if (isStrChain(curr, next)) {
                        chainCount.put(next, Math.max(chainCount.get(next), chainCount.get(curr) + 1));
                        res = Math.max(res, chainCount.get(next));
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isStrChain(String curr, String next) {
        int i = 0;
        int j = 0;
        while (i < curr.length() && j < next.length()) {
            if (curr.charAt(i) == next.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == curr.length();
    }
}
