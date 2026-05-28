class Solution {
    class Node {
        Node[] children;
        int lcs;

        Node() {
            children = new Node[26];
            lcs = -1;
        }
    }

    Node root;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int m = wordsContainer.length;
        int n = wordsQuery.length;

        root = new Node();

        for (int i = 0; i < m; i++) {
            String s = wordsContainer[i];

            Node node = root;

            for (int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                if (node.lcs == -1 || s.length() < wordsContainer[node.lcs].length()) {
                    node.lcs = i;
                }

                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Node();
                }

                node = node.children[c - 'a'];
            }

            if (node.lcs == -1 || s.length() < wordsContainer[node.lcs].length()) {
                node.lcs = i;
            }
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            String s = wordsQuery[i];

            Node node = root;

            for (int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                if (node.children[c - 'a'] == null) {
                    break;
                }
                node = node.children[c - 'a'];
            }

            result[i] = node.lcs;
        }

        return result;
    }
}
