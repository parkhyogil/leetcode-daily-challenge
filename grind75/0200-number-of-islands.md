# [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)

## Intuition
DFS 기법으로 섬의 영역을 확인해 섬의 개수를 계산할 수 있다. 

## Algorithm
`grid`의 모든 셀을 확인하여 값이 1이라면 `res`를 1 증가시키고 DFS 기법으로 섬의 영역의 값을 0으로 변경한다.\
- 현재 위치가 `grid` 범위 밖이거나 셀의 값이 0이라면 재귀함수 종료.
- 값이 1인 셀을 0으로 변경하고 상하좌우 인접한 셀로 재귀함수를 호출.


## Implementation
```java
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    recur(i, j, grid);
                }
            }
        }

        return res;
    }

    private void recur(int r, int c, char[][] grid) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        recur(r + 1, c, grid);
        recur(r - 1, c, grid);
        recur(r, c + 1, grid);
        recur(r, c - 1, grid);
    }
}
```

## Complexity
- Time complexity: O(m * n)\
`grid`의 모든 셀을 탐색한다. `m`과 `n`은 `grid`의 행과 열의 길이.

- Space complexity: O(m * n)\
재귀함수 호출로 인한 콜스택의 최대 깊이. `m`과 `n`은 `grid`의 행과 열의 길이.

