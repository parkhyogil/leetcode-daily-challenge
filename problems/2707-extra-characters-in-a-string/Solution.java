class Solution {
    private Node root;
    private int[] cache;

    public int minExtraChar(String s, String[] dictionary) {
        root = new Node();
        cache = new int[s.length()];
        Arrays.fill(cache, -1);

        for (String word : dictionary) {
            insert(word);
        }

        return recur(0, s);
    }

    private int recur(int idx, String s) {
        if (idx == s.length()) {
            return 0;
        }

        if (cache[idx] != -1) {
            return cache[idx];
        }

        int res = s.length();

        Node node = root;
        for (int i = idx; i < s.length() && node != null; i++) {
            node = node.children[s.charAt(i) - 'a'];

            res = Math.min(res, i - idx + 1 + recur(i + 1, s));
            if (node != null && node.isWord) {
                res = Math.min(res, recur(i + 1, s));
            }
        }
        return cache[idx] = res;
    }

    private void insert(String s) {
        Node node = root;

        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    class Node {
        private Node[] children;
        private boolean isWord;

        public Node() {
            children = new Node[26];
            isWord = false;
        }
    }
}
