class Solution {
    public int maximumLength(String s) {
        int n = s.length();

        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; ) {
            int j = i;

            while (j + 1 < n && s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }

            updateCount(i, j, s, countMap);

            i = j + 1;
        }

        int maxLength = -1;

        for (String key : countMap.keySet()) {
            if (countMap.get(key) >= 3) {
                maxLength = Math.max(maxLength, key.length());
            }
        }

        return maxLength;
    }

    void updateCount(int i, int j, String s, Map<String, Integer> countMap) {
        for (int k = 0; k < 3 && j - i - k >= 0; k++) {
            countMap.merge(s.substring(i, j - k + 1), 1 + k, Integer::sum);
        }
    }
}
