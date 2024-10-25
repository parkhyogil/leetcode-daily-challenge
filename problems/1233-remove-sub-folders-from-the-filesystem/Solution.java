class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[27];
            isEnd = false;
        }
    }

    TrieNode root;
    public List<String> removeSubfolders(String[] folder) {
        root = new TrieNode();

        for (String path : folder) {
            insert(path);
        }

        List<String> result = new ArrayList<>();

        for (String path : folder) {
            if (!isSubfolder(path)) {
                result.add(path);
            }
        }

        return result;
    }

    boolean isSubfolder(String path) {
        TrieNode node = root;

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            int idx = c == '/' ? 26 : c - 'a';

            node = node.children[idx];

            if (node.isEnd && i + 1 < path.length() && path.charAt(i + 1) == '/') {
                return true;
            }
        }

        return false;
    }

    void insert(String path) {
        TrieNode node = root;

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            int idx = c == '/' ? 26 : c - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.isEnd = true;
    }
}
