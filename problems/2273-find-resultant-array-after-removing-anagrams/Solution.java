class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (result.isEmpty() || !isAnagram(result.get(result.size() - 1), words[i])) {
                result.add(words[i]);
            }
        }

        return result;
    }

    boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }

        return true;
    }
}
