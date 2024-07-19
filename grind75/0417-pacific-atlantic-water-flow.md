# [417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/description/)

## Intuition
한 셀에 내린 비가 양쪽 바다로 흘러갈 수 있다면, 반대로 양쪽 바다에서 출발해 그 셀에 도착할 수 있어야 한다.
바다의 경계선에 있는 셀에서 출발해 인접한 셀의 높이가 현재 셀보다 높거나 같다면 이동하면서 두 바다에서 도착할 수 있는 셀을 찾는다.

## Algorithm
1. 두 개의 2D boolean 배열 `visitPacific`, `visitAtlantic`을 주어진 그리드 크기로 초기화한다. `true`인 셀은 내린 비가 바다로 흘러갈 수 있는 셀이다.
2. 바다에 인접한 셀에서 재귀 함수를 호출한다. 재귀 함수는 높이가 현재 셀의 높이보다 높거나 같은 인접한 셀로 퍼진다.
3. `visitPacific`, `visitAtlantic` 두 배열에서 값이 `ture`인 셀은 양쪽 바다로 흘러갈 수 있는 셀이다. 셀의 위치를 리스트에 담아 리턴한다.

## Implementation
```java
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] visitPacific = new boolean[m][n];
        boolean[][] visitAtlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, 0, heights, visitPacific);
            dfs(i, n - 1, 0, heights, visitAtlantic);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i, 0, heights, visitPacific);
            dfs(m - 1, i, 0, heights, visitAtlantic);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitPacific[i][j] && visitAtlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, int prevHeight, int[][] heights, boolean[][] visit) {
        if (r < 0 || c < 0 || r == heights.length || c == heights[0].length) {
            return;
        }

        if (prevHeight > heights[r][c] || visit[r][c]) {
            return;
        }

        visit[r][c] = true;
        int height = heights[r][c];

        dfs(r + 1, c, height, heights, visit);
        dfs(r - 1, c, height, heights, visit);
        dfs(r, c + 1, height, heights, visit);
        dfs(r, c - 1, height, heights, visit);
    }
}
```

## Complexity
`m`은 `matrix`의 행, `n`은 `matrix`의 열.

- Time complexity: O(m * n)\
- Space complexity: O(m * n)\
