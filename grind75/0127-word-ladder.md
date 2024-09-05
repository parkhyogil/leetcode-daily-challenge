# [127. Word Ladder](https://leetcode.com/problems/word-ladder/)

## Intuition
한 글자만 다른 단어끼리 연결하며 그래프를 만들고 BFS 최단 거리 알고리즘을 사용하여 문제를 해결한다.

## Algorithm
- `ladderLength` 메소드
  1. `wordList`에 `beginWord`를 추가한다.
  2. `n`에 `wordList`의 크기를 할당한다.
  3. `source`에 `beginWord`의 인덱스를 할당한다
  4. `destination`에 `endWord`의 인덱스를 할당한다. `wordList`에 `endWord`가 없을 경우 `0`을 반환하며 함수를 종료한다.
  5. `indexMap`을 빌드하고 `graph`를 빌드한다.
  6. `findShortestPath` 메소드를 호출히여 `source`에서 `destination`까지 최단거리를 반환한다.
- `findShortestPath` 메소드
  1. `queue`와 `visited`를 초기화한다.
  2. `queue`에 `source`를 추가하고 `visited`에 표시한다.
  3. `result`를 `1`로 초기화한다.
  4. `queue`가 비어있지 않다면 아래를 반복한다.
     1. `size`에 `queue`의 크기를 할당한다.
     2. `size`만큼 `queue`에서 인덱스를 꺼내 `curr`에 할당한다.
     3. `destination`에 도착했다면 `result`를 반환한다.
     4. `curr`에 연결된 다음 인덱스들을 확인하여 방문하지 않은 인덱스라면 `queue`에 추가하고 `visited`에 표시한다.
     5. `result`를 증가시킨다.
  5. `destination`까지의 경로를 찾지 못했으니 `0`을 반환한다.
- `buildIndexMap` 메소드
  1. `indexMap`을 초기화한다.
  2. `wordList`를 순회하며 단어와 인덱스를 쌍으로 `indexMap`에 추가한다.
  3. `indexMap`을 반환한다.
- `buildGraph` 메소드
  1. `graph`를 초기화한다.
  2. `wordList`를 순회하며 단어를 한 글자씩 변경하면서 변경된 단어가 `indexMap`에 존재한다면 현재 단어의 인덱스와 변경된 단어의 인덱스를 연결한다.
  3. `graph`를 반환한다.

## Implementation
```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);

        int n = wordList.size();

        int source = wordList.size() - 1;
        int destination = wordList.indexOf(endWord);

        if (destination == -1) {
            return 0;
        }

        Map<String, Integer> indexMap = buildIndexMap(n, wordList);

        List<List<Integer>> graph = buildGraph(n, wordList, indexMap);

        return findShortestPath(n, source, destination, graph);
    }

    private int findShortestPath(int n, int source, int destination, List<List<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        queue.offer(source);
        visited[source] = true;

        int result = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();

                if (curr == destination) {
                    return result;
                }

                for (int next : graph.get(curr)) {
                    if (visited[next]) {
                        continue;
                    }

                    queue.offer(next);
                    visited[next] = true;
                }
            }

            result++;
        }

        return 0;
    }

    private Map<String, Integer> buildIndexMap(int n, List<String> wordList) {
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(wordList.get(i), i);
        }

        return indexMap;
    }

    private List<List<Integer>> buildGraph(int n, List<String> wordList, Map<String, Integer> indexMap) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            char[] chars = wordList.get(i).toCharArray();

            for (int j = 0; j < chars.length; j++) {
                char tmp = chars[j];

                for (char c = 'a'; c <= 'z'; c++) {
                    chars[j] = c;

                    String s = String.valueOf(chars);

                    if (!s.equals(wordList.get(i)) && indexMap.containsKey(s)) {
                        graph.get(i).add(indexMap.get(s));
                    }
                }

                chars[j] = tmp;
            }
        }

        return graph;
    }
}
```

## Complexity
`n`은 `wordList`의 길이, `m`은 `beginWord`의 길이.
- Time complexity: O(n * m^2)
- Space complexity: O(n)
