class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            map.computeIfAbsent(getKey(s), key -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        char[] chars = s.toCharArray();

        Arrays.sort(chars);
        
        return String.valueOf(chars);
    }
}
