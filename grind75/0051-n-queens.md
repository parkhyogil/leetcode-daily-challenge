# [51. N-Queens](https://leetcode.com/problems/n-queens/)

## Intuition
Backtracking 기법을 사용한다.

체스판의 각 행을 순차적으로 순회하면서, 퀸을 놓을 열을 선택한다.

현재 체스판 상태가 유효하다면 다음 행으로 진행하고, 유효하지 않다면 이전 상태로 돌아가서 다른 열에 퀸을 놓는 방식으로 탐색을 이어간다.

## Implementation
```java
class Solution {
    int n;
    int[] board;
    char[] chars;
    boolean[] colChecker, dia1Checker, dia2Checker;
    List<List<String >> result;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;

        board = new int[n];

        chars = new char[n];
        Arrays.fill(chars, '.');
        
        colChecker = new boolean[n];
        dia1Checker = new boolean[n * 2];
        dia2Checker = new boolean[n * 2];

        result = new ArrayList<>();

        backtrack(0);

        return result;
    }

    void backtrack(int row) {
        if (row == n) {
            result.add(boardToString());
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(row, col)) {
                continue;
            }

            setVisitMark(row, col, true);

            board[row] = col;
            backtrack(row + 1);

            setVisitMark(row, col, false);
        }
    }

    void setVisitMark(int row, int col, boolean mark) {
        colChecker[col] = mark;
        dia1Checker[getDia1(row, col)] = mark;
        dia2Checker[getDia2(row, col)] = mark;
    }

    boolean isValid(int row, int col) {
        return !colChecker[col] && !dia1Checker[getDia1(row, col)] && !dia2Checker[getDia2(row, col)];
    }

    int getDia1(int row, int col) {
        return row + col;
    }

    int getDia2(int row, int col) {
        return row - col + (n - 1);
    }

    List<String> boardToString() {
        List<String> list = new ArrayList<>();

        for (int col : board) {
            chars[col] = 'Q';
            list.add(new String(chars));
            chars[col] = '.';
        }

        return list;
    }
}
```

## Complexity
- Time complexity: O(n!)
- Space complexity: O(n)
