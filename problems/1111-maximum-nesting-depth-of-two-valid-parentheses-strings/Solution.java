class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();

        int[] result = new int[n];

        int[] s = new int[n];
        int j = -1;

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                s[++j] = i;
            } else {
                result[i] = result[s[j]] = j % 2;
                j--;
            }
        }        

        return result;
    }
}
