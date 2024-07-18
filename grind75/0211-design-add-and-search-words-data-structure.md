# [211. Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)

## Intuition
Trie 자료구조를 이용해 구현한다.

## Algorithm
- `search()` 메소드를 재귀 함수로 구현해 위치한 인덱스의 문자가 `.`일 경우 모든 자식 노드에서 함수를 호출해 문자열을 찾는다.

## Implementation
```java
class WordDictionary {
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
            return recur(0, root, word);
        }

        private boolean recur(int idx, TrieNode node, String word) {
            if (node == null) {
                return false;
            }

            if (idx == word.length()) {
                return node.isWord;
            }

            if (word.charAt(idx) == '.') {
                for (TrieNode child : node.children) {
                    if (recur(idx + 1, child, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                return recur(idx + 1, node.children[word.charAt(idx) - 'a'], word);
            }
        }

        class TrieNode {
            private TrieNode[] children;
            private boolean isWord;

            private TrieNode() {
                children = new TrieNode[26];
                isWord = false;
            }
        }
    }
    
    private Trie trie;

    public WordDictionary() {
        trie = new Trie();    
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
```

## Complexity
`m`은 삽입된 문자열의 개수, `n`은 문자열의 길이.
- Time complexity:
  - `add` : O(n)
  - `search` : O(n * 26 * 26) -> O(n)
- Space complexity: O(m * n)
