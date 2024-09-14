# [329. Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/)

## Intuition
`matrix`를 각 셀을 노드로 보고, 값이 큰 노드에서 작은 노드로만 이동할 수 있는 엣지로 연결된 그래프로 생각할 수 있다.

아래는 주어진 `matrix`를 그래프로 변경한 것이다.
```
matrix = {               9 → 5 → 4
    {9, 5, 4},           ↓   ↑   ↑
    {6, 6, 8},    ->     6   6 ← 8
    {2, 1, 1}            ↓   ↓   ↓
}                        2 → 1   1
```
임의의 노드에서 가질 수 있는 최장 경로는 연결된 노드의 최장 경로 중 가장 긴 경로를 선택하는 것이다. 
이를 재귀적으로 구현하여 현재 노드의 경로를 구하기 위해 먼저 연결된 노드의 경로 길이를 계산한다.

셀 `(1,0)`의 최장 길이는 `3`이다.
```
path            length
6               3 
↓               ↓  
2 → 1           2 → 1 
```
셀 `(0,0)`의 최장 길이는 `4`이다.
```
path            length
9 → 5 → 4       4 → 2 → 1
↓               ↓
6               3 
↓               ↓  
2 → 1           2 → 1 
```
여기서 알 수 있는 점은 이전에 계산했던 경로를 재사용할 수 있다는 것이다. 한 번 계산된 경로는 변하지 않으므로, 이를 저장해두고 다시 사용할 수 있다.

이를 위해 `DFS` 기법을 사용하여 그래프를 순회하고, `Memoization` 기법을 통해 이미 계산한 경로를 저장하여 중복 계산을 피한다. 이렇게 하면 더 효율적으로 문제를 해결할 수 있다.

## Implementation

```java
class Solution {
    private final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] maxLengthForCell = new int[m][n];

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, findMaxLength(i, j, matrix, maxLengthForCell));
            }
        }

        return result;
    }

    private int findMaxLength(int row, int col, int[][] matrix, int[][] maxLengthForCell) {
        if (maxLengthForCell[row][col] > 0) {
            return maxLengthForCell[row][col];
        }

        int maxLength = 1;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isOutOfBoundary(newRow, newCol, matrix.length, matrix[0].length) || matrix[row][col] <= matrix[newRow][newCol]) {
                continue;
            }

            maxLength = Math.max(maxLength, findMaxLength(newRow, newCol, matrix, maxLengthForCell) + 1);
        }

        return maxLengthForCell[row][col] = maxLength;
    }

    private boolean isOutOfBoundary(int row, int col, int numRows, int numCols) {
        return row < 0 || row == numRows || col < 0 || col == numCols;
    }
}

```

## Complexity
`m`은 `matrix`의 길이, `n`은 `matrix[0]`의 길이
- Time complexity: O(m * n)
- Space complexity: O(m * n)
