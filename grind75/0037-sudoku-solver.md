# [37. Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)

## Intuition
**Backtracking** 기법을 사용한다.

순차적으로 빈 칸에 가능한 모든 숫자를 대입해보며, 유효하지 않을 경우 나머지 빈 칸을 채우지 않고 돌아가 다음 후보를 찾아 시도한다.

## Implementation
```java
class Solution {
    boolean[][] rowChecker, colChecker, boxChecker;

    public void solveSudoku(char[][] board) {
        rowChecker = new boolean[9][10];
        colChecker = new boolean[9][10];
        boxChecker = new boolean[9][10];

        List<int[]> emptyCells = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    setChecker(i, j, getBoxNum(i, j), Character.digit(board[i][j], 10), true);
                } else {
                    emptyCells.add(new int[] {i, j});
                }
            }
        }

        solve(0, emptyCells, board);
    }

    boolean solve(int index, List<int[]> emptyCells, char[][] board) {
        if (index == emptyCells.size()) {
            return true;
        }

        int row = emptyCells.get(index)[0];
        int col = emptyCells.get(index)[1];
        int boxNum = getBoxNum(row, col);

        for (int num = 1; num <= 9; num++) {
            if (!isValid(row, col, boxNum, num)) {
                continue;
            }

            setChecker(row, col, boxNum, num, true);

            board[row][col] = Character.forDigit(num, 10);

            if (solve(index + 1, emptyCells, board)) {
                return true;
            }

            setChecker(row, col, boxNum, num, false);
        }

        board[row][col] = '.';

        return false;
    }

    boolean isValid(int row, int col, int boxNum, int num) {
        return !rowChecker[row][num] && !colChecker[col][num] && !boxChecker[boxNum][num];
    }

    void setChecker(int row, int col, int boxNum, int num, boolean isContaining) {
        rowChecker[row][num] = isContaining;
        colChecker[col][num] = isContaining;
        boxChecker[boxNum][num] = isContaining;
    }

    int getBoxNum(int row, int col) {
        return (row / 3 * 3) + (col / 3);
    }
}
```

## Complexity
`n`은 비어있는 셀의 개수
- Time complexity: O(9^n)
- Space complexity: O(n)
