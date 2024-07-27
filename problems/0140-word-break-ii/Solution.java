class Solution {
    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;
        private String word;

        private TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = null;
        }
    }

    private TrieNode root;

    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();

        for (String word : wordDict) {
            insert(word);
        }

        List<String> res = new ArrayList<>();

        recur(0, s, new ArrayList<>(), res);

        return res;
    }

    private void recur(int idx, String s, List<String> list, List<String> res) {
        if (idx == s.length()) {
            res.add(construct(list));
            return;
        }

        TrieNode node = root;
        for (int i = idx; i < s.length() && node != null; i++) {
            node = node.children[s.charAt(i) - 'a'];
            if (node != null && node.isWord) {
                list.add(node.word);
                recur(i + 1, s, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private String construct(List<String> list) {
        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s).append(' ');
        }   

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }

        node.isWord = true;
        node.word = word;
    }

    public boolean contains(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            node = node.children[c - 'a'];

            if (node == null) {
                return false;
            }
        }

        return node.isWord;
    }
}
