# [79. Word Search](https://leetcode.com/problems/word-search/description/)

## Intuition
위치한 셀의 문자가 현재 재귀함수 깊이에서 찾는 문자열의 문자와 같다면 인접한 셀로 다음 재귀함수를 호출해 모든 문자를 탐색할 수 있다.

## Algorithm
1. `recur(r, c, idx, word, board, visit)` 재귀함수를 정의한다.
   - `r` : 위치한 `board`의 행.
   - `c` : 위치한 `board`의 열.
   - `idx` : 진행 중인 문자열의 문자 인덱스.
   - `visited` : 중복을 방지하기 위한 배열.
   - 재귀함수의 동작은 아래과 같다.
     1. `idx == word.length()`라면 모든 문자를 찾았으니 `true`를 리턴하며 재귀함수를 종료.
     2. 현재 위치가 `board` 밖이라면 `false`를 리턴하며 재귀함수 종료.
     3. 방문한 위치거나 `board`의 문자와 `word`의 문자가 다르다면 `false`를 리턴하며 재귀함수 종료.
     4. `visited`에 방문 표시.
     5. 인접한 셀로 다음 재귀함수를 호출한다. 만약 모든 문자를 찾아 `true`가 리턴 된다면 즉시 `true`를 리턴.
     6. 모든 문자를 찾지 못했으니 `visited`에 방문 표시를 제거하고 `false`를 리턴하며 재귀함수 종료.
2. `word`에 있는 문자들이 `board`에 충분하지 않다면 `false` 리턴.
3. `board`의 모든 셀에서 재귀함수를 호출해 `true`를 리턴하는 셀이 있다면 `true`를 리턴하고 아니라면 `false`를 리턴.

## Implementation
```java
class Solution {
    private int[][] dir = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    }; 

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        if (m * n < word.length() || !hasEnoughCharacter(board, word)) {
            return false;
        }

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (recur(i, j, 0, word, board, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean recur(int r, int c, int idx, String word, char[][] board, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r == board.length || c == board[0].length) {
            return false;
        }

        if (visited[r][c] || board[r][c] != word.charAt(idx)) {
            return false;
        }
        
        visited[r][c] = true;

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (recur(nr, nc, idx + 1, word, board, visited)) {
                return true;
            }
        }

        visited[r][c] = false;

        return false;
    }

    private boolean hasEnoughCharacter(char[][] board, String word) {
        int[] count = new int[128];

        for (char[] arr : board) {
            for (char c : arr) {
                count[c]++;
            }
        }

        for (char c : word.toCharArray()) {
            count[c]--;
        }

        for (int i : count) {
            if (i < 0) {
                return false;
            }
        }

        return true;
    }
}
```

## Complexity
`m`은 `board`의 행, `n`은 `board`의 열, `k`는 `word`의 길이.
- Time complexity: O(m * n * 4^k)\
재귀함수는 최악의 경우 `4^k`의 시간 복잡도를 갖는다. 모든 셀에 재귀함수를 호출하니 최종 시간 복잡도는 `O(m * n * 4^k)`이 된다.

- Space complexity: O(m * n + k)\
재귀함수는 최대 `k`의 콜스택을 사용하고 `visit` 배열에서 `m * n`의 공간을 사용한다.

