class Solution {
    public List<String> commonChars(String[] words) {
        int[] countCommon = new int[26];
        Arrays.fill(countCommon, Integer.MAX_VALUE);

        for (String word : words) {
            int[] count = new int[26];
            
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                countCommon[i] = Math.min(countCommon[i], count[i]);
            }
        }

        List<String> res = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            String s = String.valueOf(c);

            for (int i = 0; i < countCommon[c - 'a']; i++) {
                res.add(s);
            }
        }

        return res;
    }
}
