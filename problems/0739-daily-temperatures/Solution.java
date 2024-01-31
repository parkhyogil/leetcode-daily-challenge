class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] stack = new int[n];
        int idx = -1;

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while (idx != -1 && temperatures[i] > temperatures[stack[idx]]) {
                res[stack[idx]] = i - stack[idx];
                idx--;
            }

            stack[++idx] = i;
        }

        return res;
    }
}
