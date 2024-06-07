class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for (String word : dictionary) {
            trie.insert(word);
        }

        String[] splits = sentence.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String word : splits) {
            sb.append(trie.getRoot(word)).append(' ');
        }

        return sb.toString().trim();
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }

        node.word = word;
        node.isWord = true;
    }

    public String getRoot(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            node = node.children[c - 'a'];

            if (node == null) {
                break;
            }

            if (node.isWord) {
                return node.word;
            }
        }

        return word;
    }

    private class TrieNode {
        private TrieNode[] children;
        private String word;
        private boolean isWord;

        private TrieNode() {
            children = new TrieNode[26];
            word = null;
            isWord = false;
        }
    }
}
