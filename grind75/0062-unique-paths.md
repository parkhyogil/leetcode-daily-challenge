# [62. Unique Paths](https://leetcode.com/problems/unique-paths/description/)

## Intuition
모든 경우의 수를 계산할 경우 같은 위치를 여러 번 계산해서 시간 초과가 발생한다.\
한번 계산한 위치는 값을 저장해서 중복으로 계산하는 일이 없도록 한다.

## Algorithm
1. 재귀함수를 호출해 `memo` 배열을 완성한다.
   1. 현재 위치가 배열의 밖일 경우 `0`을 리턴.
   2. 현재 위치가 시작 지점일 경우 `1`을 리턴.
   3. 이미 방문했던 위치라면 계산된 값 `memo[r][c]`를 리턴.
   4. 처음 방문하는 위치라면 `(r - 1, c)` 값과 `(r, c - 1)` 값을 찾아 저장하고 리턴.
2. 도착 지점의 경우의 수 `memo[m - 1][n - 1]`를 리턴한다.

## Implementation
```java
class Solution {
    public int uniquePaths(int m, int n) {
        return recur(m - 1, n - 1, new int[m][n]);
    }

    private int recur(int r, int c, int[][] memo) {
        if (r < 0 || c < 0) {
            return 0;
        }
        if (r == 0 && c == 0) {
            return 1;
        }
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        return memo[r][c] = recur(r - 1, c, memo) + recur(r, c - 1, memo);
    }
}
```

## Complexity
`m`은 `grid`의 행의 개수, `n`은 `grid`의 열의 개수.
- Time complexity: O(m * n)\
`memo` 배열을 계산하는 데 사용한 시간.

- Space complexity: O(m * n)\
`memo` 배열에서 사용한 공간.