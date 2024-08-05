class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String s : arr) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }

        for (String s : arr) {
            if (frequencyMap.get(s) == 1) {
                k--;
            }

            if (k == 0) {
                return s;
            }
        }

        return "";
    }
}
