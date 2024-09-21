# [336. Palindrome Pairs](https://leetcode.com/problems/palindrome-pairs/description/)

## Intuition
두 문자열 `words[i], words[j]`를 이어서 회문이 되는 문자열의 쌍 `(i, j)`를 찾는다. 쌍의 조건은 아래와 같다.

- `0 <= i, j < words.length`
- `i != j`
- `words[i] + words[j]`는 회문이다.

한 문자열을 기준으로 다른 문자열을 뒤에 붙이는 경우와 앞에 붙이는 경우가 있다.

먼저 뒤에 붙이는 경우를 살펴본다.

두 문자열 `"sssll"`, `"lsss"`를 붙이면 회문이 된다.\
긴 문자열을 기준으로 앞부분의 `"sssl"`은 `"lsss"`와 대칭이고, 나머지 문자열 `"l"`은 회문이다.\
문자열을 뒤에 붙일 때 기준이 되는 문자열의 앞부분부터 부분 문자열을 확인한다.\
현재까지 확인한 부분 문자열이 주어진 배열에 존재하고 나머지 부분 문자열이 회문이라면, 두 문자열을 이어 붙인 문자열 또한 회문이 된다.

다음으로, 앞에 붙이는 경우를 살펴본다.

두 문자열 `"lls"`, `"sssll"`을 붙이면 회문이 된다.\
긴 문자열을 기준으로 뒷부분의 `"sll"`은 `"lls"`와 대칭이고, 나머지 문자열 `"ss"`는 회문이다.\
문자열을 앞에 붙일 때 기준이 되는 문자열의 뒷부분부터 부분 문자열을 확인한다.\
현재까지 확인한 부분 문자열이 주어진 배열에 존재하고 나머지 부분 문자열이 회문이라면, 두 문자열을 이어 붙인 문자열 또한 회문이 된다.

주어진 문자열 배열에서 부분 문자열을 효율적으로 검색하기 위해 **Trie** 자료구조를 사용한다.

두 개의 Trie를 사용하여 문제를 해결한다.\
하나는 문자열을 그대로 삽입하고, 나머지 하나는 문자열을 역순으로 삽입한다.
뒤에 붙일 문자열을 찾는 경우 역순 Trie에서 검색하고, 앞에 붙일 문자열을 찾을 때는 뒤집은 문자열을 정순 Trie에서 검색한다.

TrieNode는 현재 노드가 문자열의 끝인지 표시하는 `wordIndex`를 갖는다.
현재까지 탐색한 부분 문자열이 주어진 배열에 존재하고, 나머지 부분 문자열이 회문이라면, 현재 문자열의 인덱스와 노드의 `wordIndex`를 한 쌍으로 여길 수 있다.

## Implementation
```java
class Solution {
    class TrieNode {
        int wordIndex;
        TrieNode[] children;

        TrieNode() {
            wordIndex = -1;
            children = new TrieNode[26];
        }
    }

    TrieNode trie;
    TrieNode reversedTrie;

    public List<List<Integer>> palindromePairs(String[] words) {
        trie = new TrieNode();
        reversedTrie = new TrieNode();

        Map<String, Integer> wordIndexMap = new HashMap<>();

        int n = words.length;

        for (int i = 0; i < n; i++) {
            String word = words[i];

            wordIndexMap.put(word, i);

            insert(trie, word, i);
            insert(reversedTrie, new StringBuilder(word).reverse().toString(), i);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = words[i];

            if (word.isEmpty()) {
                continue;
            }

            String reversedWord = new StringBuilder(word).reverse().toString();

            if (wordIndexMap.containsKey(reversedWord) && i != wordIndexMap.get(reversedWord)) {
                result.add(List.of(i, wordIndexMap.get(reversedWord)));
            }

            findPair(i, word, result, true);
            findPair(i, reversedWord, result, false);
        }

        return result;
    }

    void findPair(int index, String word, List<List<Integer>> result, boolean putBehind) {
        int m = word.length();
        TrieNode node = putBehind ? reversedTrie : trie;

        for (int j = 0; j < m && node != null; j++) {
            if (node.wordIndex != -1 && index != node.wordIndex && isPalindrome(word, j, m - 1)) {
                if (putBehind) {
                    result.add(List.of(index, node.wordIndex));
                } else {
                    result.add(List.of(node.wordIndex, index));
                }
            }

            char c = word.charAt(j);
            node = node.children[c - 'a'];
        }
    }

    void insert(TrieNode root, String word, int index) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }

            node = node.children[c - 'a'];
        }

        node.wordIndex = index;
    }

    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

## Complexity
`n`은 배열 `words`의 길이, `m`은 `word`의 최대 길이
- Time complexity: O(n * m^2)
- Space complexity: O(n * m)
