class Solution {
    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public int minExtraChar(String s, String[] dictionary) {
        initializeTrie(dictionary);

        int n = s.length();

        int[] cache = new int[n];
        Arrays.fill(cache, -1); 

        return findMinExtraChar(0, n, s, cache);
    }

    int findMinExtraChar(int index, int len, String s, int[] cache) {
        if (index == len) {
            return 0;
        } 

        if (cache[index] != -1) {
            return cache[index];
        }

        int i = index;
        int minNum = len;

        TrieNode node = root;

        while (i < len && node != null) {
            node = node.children[s.charAt(i) - 'a'];

            if (node != null && node.isEndOfWord) {
                minNum = Math.min(minNum, findMinExtraChar(i + 1, len, s, cache));
            } else {
                minNum = Math.min(minNum, findMinExtraChar(i + 1, len, s, cache) + (i - index + 1));
            }

            i++;
        }

        return cache[index] = minNum;
    }

    void initializeTrie(String[] words) {
        root = new TrieNode();

        for (String word : words) {
            insert(word);
        }
    }

    void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }

        node.isEndOfWord = true;
    }
}
