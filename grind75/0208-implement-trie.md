# [208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/description/)

## Intuition
문자별로 노드를 만들어서 트리 구조를 만든다.

## Implementation
```java
class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = getLastNode(word);
        return node != null&& node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return getLastNode(prefix) != null;
    }

    private TrieNode getLastNode(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            node = node.children[idx];
            if (node == null) {
                break;
            }
        }

        return node;
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        private TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

## Complexity
- Time complexity: 
  - insert: O(n). `n` 은 `word`의 길이.
  - search: O(n). `n` 은 `word`의 길이.
  - startsWith: O(n). `n` 은 `word`의 길이.

- Space complexity: O(m)\
`m`은 삽입된 `word`의 문자 개수.