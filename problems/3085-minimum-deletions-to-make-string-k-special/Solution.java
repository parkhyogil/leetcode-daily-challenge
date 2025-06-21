class Solution {
    public int minimumDeletions(String word, int k) {
        int n = word.length();

        int[] count = new int[26];

        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        Arrays.sort(count);

        int result = n;
        
        int left = 0;
        int right = n;

        for (int i = 0, j = 0; i < 26; i++) {
            while (j < 26 && count[j] - count[i] <= k) {
                right -= count[j++];
            }

            result = Math.min(result, left + right - (count[i] + k) * (26 - j));

            left += count[i];
        }

        return result;
    }
}
