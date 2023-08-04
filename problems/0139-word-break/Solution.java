class Solution {
    Node root;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        root = new Node();
        for (String word : wordDict) {
            insert(word);
        }

        return recur(0, s, new Boolean[n]);
    }

    private void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    private boolean recur(int idx, String s, Boolean[] memo) {
        if (idx == s.length()) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        Node node = root;
        for (int i = idx; i < s.length() && node.children[s.charAt(i) - 'a'] != null; i++) {
            node = node.children[s.charAt(i) - 'a'];
            if (node.isWord && recur(i + 1, s, memo)) {
                return memo[idx] = true;
            }
        }
        return memo[idx] = false;
    }

    private class Node {
        private Node[] children;
        private boolean isWord;

        private Node() {
            children = new Node[26];
            isWord = false;
        }
    }
}
