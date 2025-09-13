class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        int maxV = -1;
        int maxC = -1;

        for (char c : s.toCharArray()) {
            int i = c - 'a';
            freq[i]++;

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                if (maxV == -1 || freq[i] > freq[maxV]) {
                    maxV = i;
                }
            } else {
                if (maxC == -1 || freq[i] > freq[maxC]) {
                    maxC = i;
                }
            }
        }

        return (maxV > -1 ? freq[maxV] : 0) + (maxC > -1 ? freq[maxC] : 0);
    }
}
