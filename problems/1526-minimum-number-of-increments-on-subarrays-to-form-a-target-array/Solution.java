class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;

        int result = 0;

        int[] stack = new int[n];
        int idx = -1;

        for (int i = 0; i < n; i++) {
            if (idx > -1 && stack[idx] > target[i]) {
                result += stack[idx] - target[i];
                while (idx > -1 && stack[idx] > target[i]) {
                    idx--;
                }
            }
            stack[++idx] = target[i];
        }

        result += stack[idx];

        return result;
    }
}
