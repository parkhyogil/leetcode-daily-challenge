class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        int[] lastIndex = new int[26];

        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();

        for (int l = 0, r = 0; l < n;) {
            for (int i = l; i != (r = Math.max(r, lastIndex[s.charAt(i) - 'a'])); i++) {}
            result.add(r - l + 1);
            l = r + 1;
        }

        return result;
    }
}
