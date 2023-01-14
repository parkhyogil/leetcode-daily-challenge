class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();

        int[] root = new int[26];
        for (int i = 0; i < 26; i++) {
            root[i] = i;
        }

        for (int i = 0; i < n; i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a', root);
        }

        StringBuilder sb = new StringBuilder(n);
        for (char c : baseStr.toCharArray()) {
            sb.append((char) ('a' + getRoot(c - 'a', root)));
        }
        return sb.toString();
    }

    private void union(int c1, int c2, int[] root) {
        c1 = getRoot(c1, root);
        c2 = getRoot(c2, root);

        if (c1 < c2) {
            root[c2] = c1;
        } else {
            root[c1] = c2;
        }
    }

    private int getRoot(int child, int[] root) {
        if (child == root[child]) {
            return child;
        }
        return root[child] = getRoot(root[child], root);
    }
}
