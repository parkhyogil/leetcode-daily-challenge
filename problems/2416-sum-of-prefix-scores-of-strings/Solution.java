class Solution {
    class TrieNode {
        int numPrefixes;
        TrieNode[] children;

        TrieNode() {
            numPrefixes = 0;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;

        root = new TrieNode();

        for (String word : words) {
            insert(word);
        }

        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = sumNumPrefixes(words[i]);
        }

        return result;
    }

    int sumNumPrefixes(String word) {
        TrieNode node = root;
        int sum = 0;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (node.children[idx] == null) {
                break;
            }

            node = node.children[idx];
            sum += node.numPrefixes;
        }

        return sum;
    }

    void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
            node.numPrefixes++;
        }
    }
}
