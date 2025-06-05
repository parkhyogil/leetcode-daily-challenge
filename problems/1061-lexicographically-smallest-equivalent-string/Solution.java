class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        int m = baseStr.length();

        int[] roots = new int[26];
        for (int i = 0; i < 26; i++) {
            roots[i] = i;
        }

        for (int i = 0; i < n; i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a', roots);
        }

        char[] chars = new char[m];
        
        for (int i = 0; i < m; i++) {
            chars[i] = (char) (findRoot(baseStr.charAt(i) - 'a', roots) + 'a');
        }

        return String.valueOf(chars);
    }

    private void union(int a, int b, int[] roots) {
        a = findRoot(a, roots);
        b = findRoot(b, roots);

        if (a < b) {
            roots[b] = a;
        } else {
            roots[a] = b;
        }
    }

    private int findRoot(int child, int[] roots) {
        if (child == roots[child]) {
            return child;
        }
        return roots[child] = findRoot(roots[child], roots);
    }
}
