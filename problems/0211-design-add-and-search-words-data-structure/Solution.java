class WordDictionary {
    private TrieNode[] roots;

    public WordDictionary() {
        roots = new TrieNode[26];    
    }
    
    public void addWord(String word) {
        int len = word.length();
        if (roots[len] == null) {
            roots[len] = new TrieNode();
        }
        roots[len].insert(word);
    }
    
    public boolean search(String word) {
        int len = word.length();
        return roots[len] != null && roots[len].search(word, 0);
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }

        void insert(String word) {
            TrieNode node = this;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isWord = true;
        }

        boolean search(String word, int idx) {
            if (idx == word.length()) {
                return isWord;
            }
            char c = word.charAt(idx);
            if (c == '.') {
                for (TrieNode child : children) {
                    if (child != null && child.search(word, idx + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                return children[c - 'a'] != null && children[c - 'a'].search(word, idx + 1);
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
