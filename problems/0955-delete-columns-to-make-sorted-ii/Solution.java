class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();

        boolean[] deleted = new boolean[m];

        int result = 0;

        int i = 0;

        while (i < n - 1 && result < m) {
            int j = 0;
            while (j < m && deleted[j]) {
                j++;
            }

            while (j < m) {
                char c0 = strs[i].charAt(j), c1 = strs[i + 1].charAt(j);

                if (c0 < c1) {
                    break;
                } else if (c0 == c1) {
                    j++;
                    while (j < m && deleted[j]) {
                        j++;
                    }
                } else {
                    deleted[j] = true;
                    result++;
                    i = -1;
                    break;
                }
            }
            i++;
        }

        return result;
    }
}
