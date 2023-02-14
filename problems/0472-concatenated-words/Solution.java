class Solution {
    Node root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Node();
        
        for (String word : words) {
            insert(word);
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isConcatenatedWord(0, 0, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isConcatenatedWord(int idx, int depth, String word) {
        int len = word.length();
        
        if (idx == len) {
            return depth > 1;
        }

        Node node = root;
        for (int i = idx; i < len; i++) {
            node = node.children[word.charAt(i) - 'a'];
            if (node == null) {
                break;
            }
            if (node.isWord && isConcatenatedWord(i + 1, depth + 1, word)) {
                return true;
            }
        }
        return false;
    }

    private void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];
        }
        node.isWord = true;
    }

    class Node {
        Node[] children;
        boolean isWord;

        Node() {
            children = new Node[26];
            isWord = false;
        }
    }
}
