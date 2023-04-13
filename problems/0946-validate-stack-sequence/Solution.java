class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;

        int idx = -1;
        for (int i = 0, j = 0; i < n; i++) {
            pushed[++idx] = pushed[i];

            while (idx >= 0 && pushed[idx] == popped[j]) {
                idx--;
                j++;
            }
        }
        return idx == -1;
    }
}
