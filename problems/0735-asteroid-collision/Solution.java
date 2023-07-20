class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        int[] stack = new int[n];
        int idx = -1;

        for (int i = 0; i < n; i++) {
            int a = asteroids[i];

            if (a > 0) {
                stack[++idx] = a;
            } else {
                while (idx > -1 && stack[idx] > 0 && stack[idx] < Math.abs(a)) {
                    idx--;
                }
                if (idx == -1 || stack[idx] < 0) {
                    stack[++idx] = a;
                } else if (stack[idx] == Math.abs(a)) {
                    idx--;
                }
            }
        }
        return Arrays.copyOf(stack, idx + 1);
    }
}
