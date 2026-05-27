class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();

        int[] idx = new int[128];
        Arrays.fill(idx, -1);

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (c <= 'Z') {
                if (idx[c] == -1) {
                    idx[c] = i;
                }
            } else {
                idx[c] = i;
            }
        }

        int result = 0;
        
        for (char c = 'A'; c <= 'Z'; c++) {
            if (idx[c + 32] > -1 && idx[c + 32] < idx[c]) {
                result++;
            }
        }

        return result;
    }
}
