# [212. Word Search II](https://leetcode.com/problems/word-search-ii/)

## Intuition

**Backtracking** 기법을 사용하여 단어를 찾을 수 있지만, 하나의 셀에서 `words` 길이만큼 backtracking을 수행하면 시간 복잡도가 매우 커진다.

이를 **Trie** 자료구조를 사용해 최적화할 수 있다. 단어들을 Trie에 삽입하면, 각 셀에서 한 번의 backtracking만으로 여러 단어를 효율적으로 탐색할 수 있게 된다.

또한, TrieNode를 필요에 따라 제거하여 추가적인 최적화를 할 수 있다. 
TrieNode에 현재 노드에서 구성된 단어의 수를 저장해 둔다. 
backtracking을 수행하여 단어를 찾았을 때, 해당 단어를 지우고 그 과정에서 지워진 단어의 수를 반환한다.
이후, 반환된 값만큼 TrieNode에서 단어의 수를 감소시킨다. 
TrieNode에 저장된 단어 수가 0이 되면, 해당 노드는 더 이상 탐색할 필요가 없으므로 제거하여 성능을 더욱 향상시킬 수 있다.

주어진 board와 words가 아래와 같다면
```
board = {{'a','a','c'},     words = {"aa","aab","aac"};
         {'b','b','b'},                                                         
         {'a','a','c'}};                                                        
```

Trie를 아래와 같이 구성된다. 괄호 안의 숫자는 노드가 구성하는 단어의 수를 의미한다.
```
Trie = root → 'a'(3) → 'a'(3) → 'b'(1)
                              ↘
                                'c'(1)
```

셀(0,0)에서 backtracking을 수행하여 (0,0) -> (0,1) -> (1,1) 순서로 탐색해 "aab"를 찾는다.

(1,1)에서 더 진행할 수 없으니 노드 제거 작업을 수행하고 재귀함수를 종료한다.
현재 단어를 1개 찾았으니 `b`노드의 단어 구성 수를 1 감소시킨다. 단어 구성 수가 0이 되어 노드를 제거하고 (0,1)로 1을 반환한다.

현재 Trie 상태는 아래와 같다.
```
Trie = root → 'a'(3) → 'a'(3)
                              ↘
                                'c'(1)
```
(0,1) -> (0,2)로 이동하여 "aac"를 찾는다.

(0,2)에서 더 진행할 수 없으니 노드 제거 작업을 수행하고 재귀함수를 종료한다.
현재 단어를 1개 찾았으니 `c`노드의 단어 구성 수를 1 감소시킨다. 단어 구성 수가 0이 되어 노드를 제거하고 (0,1)로 1을 반환한다.

현재 Trie 상태는 아래와 같다.
```
Trie = root → 'a'(3) → 'a'(3)
```
현재 위치한 (0,1)이 반환받은 수는 2이고, 단어 "aa"를 찾아 찾은 단어의 수는 3이 된다.

남은 노드를 모두 제거하여 Trie는 비어있는 상태가 된다. 위와 같은 과정으로 Trie 노드를 제거해 더 효율적으로 문제를 해결할 수 있다. 


## Implementation
```java
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.addWord(word);
        }

        return trie.removeWordInMatrix(board);
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                node = node.getOrCreateChild(c);
                node.updateWordNumbers(1);
            }

            node.markAsWord(word);
        }

        public List<String> removeWordInMatrix(char[][] matrix) {
            List<String> removedWords = new ArrayList<>();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dfs(root, i, j, matrix, removedWords);
                }
            }

            return removedWords;
        }

        private int dfs(TrieNode parent, int row, int col, char[][] matrix, List<String> removedWords) {
            if (row < 0 || col < 0 || row == matrix.length || col == matrix[0].length || matrix[row][col] == '*' || !parent.hasChild(matrix[row][col])) {
                return 0;
            }

            char c = matrix[row][col];

            TrieNode node = parent.getChild(c);

            int removedWordNumbers = 0;

            matrix[row][col] = '*';

            removedWordNumbers += dfs(node, row - 1, col, matrix, removedWords);
            removedWordNumbers += dfs(node, row + 1, col, matrix, removedWords);
            removedWordNumbers += dfs(node, row, col - 1, matrix, removedWords);
            removedWordNumbers += dfs(node, row, col + 1, matrix, removedWords);

            matrix[row][col] = c;

            if (node.isWordNode()) {
                removedWords.add(node.removeWord());
                removedWordNumbers++;
            }

            if (node.updateWordNumbers(-removedWordNumbers) == 0) {
                parent.removeChild(c);
            }

            return removedWordNumbers;
        }

        private class TrieNode {
            private int wordNumbers;
            private String word;
            private boolean isWord;
            private TrieNode[] children;

            private TrieNode() {
                wordNumbers = 0;
                word = null;
                isWord = false;
                children = new TrieNode[26];
            }

            private boolean hasChild(char c) {
                return children[c - 'a'] != null;
            }

            private TrieNode getChild(char c) {
                return children[c - 'a'];
            }

            private TrieNode getOrCreateChild(char c) {
                int index = c - 'a';

                if (!hasChild(c)) {
                    children[index] = new TrieNode();
                }

                return children[index];
            }

            private boolean isWordNode() {
                return isWord;
            }
            
            private void markAsWord(String word) {
                this.word = word;
                isWord = true;
            }

            public String removeWord() {
                String removed = word;

                word = null;
                isWord = false;

                return removed;
            }

            public int updateWordNumbers(int delta) {
                return wordNumbers += delta;
            }

            public void removeChild(char c) {
                children[c - 'a'] = null;
            }
        }
    }
}
```

## Complexity
`m`은 `board`의 행, `n`은 `board`의 열, `k`는 `words`의 길이, `l`은 `word`의 최대 길이.
- Time complexity: O((m * n * 4 * 3^(l - 1)) + (k * l))
  - 모든 셀에서 backtracking을 수행한 시간과 Trie 빌드에 사용한 시간
- Space complexity: O(k * l)
