class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] setsByFirstLetter = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            setsByFirstLetter[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            setsByFirstLetter[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        
        long res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                int count = 0;
                for (String s : setsByFirstLetter[i]) {
                    if (setsByFirstLetter[j].contains(s)) {
                        count++;
                    }
                }
                res += (setsByFirstLetter[i].size() - count) * (setsByFirstLetter[j].size() - count) * 2;
            }
        }
        return res;
    }
}
