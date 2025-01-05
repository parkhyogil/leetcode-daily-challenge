class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();

        int[] prefixSum = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) {
                prefixSum[start]++;
                prefixSum[end + 1]--;
            } else {
                prefixSum[start]--;
                prefixSum[end + 1]++;
            }
        }

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            prefixSum[i] = prefixSum[i] % 26 + 26;
            prefixSum[i + 1] += prefixSum[i];

            sb.append((char) ((s.charAt(i) - 'a' + prefixSum[i]) % 26 + 'a'));
        }

        return sb.toString();
    }
}
