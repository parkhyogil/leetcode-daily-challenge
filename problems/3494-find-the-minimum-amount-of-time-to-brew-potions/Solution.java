class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;

        long[] time = new long[n + 1];

        for (int i = 0; i < m; i++) {
            long[] next = new long[n + 1];

            for (int j = 0; j < n; j++) {
                next[j + 1] = (long) skill[j] * mana[i] + Math.max(next[j], time[j + 1]);
            }

            for (int j = n - 1; j >= 0; j--) {
                next[j] = Math.max(next[j], next[j + 1] - (long) skill[j] * mana[i]);
            }

            time = next;
        }

        return time[n];
    }
}
