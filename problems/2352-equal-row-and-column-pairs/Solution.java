class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(grid[i]);
        }

        int res = 0;
        int[] col = new int[n];
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n; r++) {
                col[r] = grid[r][c];
            }
            res += trie.search(col);
        }
        return res;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(int[] arr) {
        Node node = root;
        for (int num : arr) {
            if (!node.children.containsKey(num)) {
                node.children.put(num, new Node());
            }
            node = node.children.get(num);
        }
        node.count++;
    }

    public int search(int[] arr) {
        Node node = root;
        for (int num : arr) {
            node = node.children.get(num);
            if (node == null) {
                return 0;
            }
        }
        return node.count;
    }

    private class Node {
        private int count;
        private Map<Integer, Node> children;

        private Node() {
            count = 0;
            children = new HashMap<>();
        }
    }
}
