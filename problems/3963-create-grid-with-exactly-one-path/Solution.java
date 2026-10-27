class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];

        char[] a = new char[n];
        Arrays.fill(a, '#');
        a[0] = '.';

        for (int i = 0; i < m - 1; i++) {
            result[i] = String.valueOf(a);
        }

        Arrays.fill(a, '.');
        result[m - 1] = String.valueOf(a);

        return result;
    }
}
