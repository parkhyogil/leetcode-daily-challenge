# [36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)

## Intuition
각 행, 열, 3*3 상자의 숫자를 HashSet으로 관리하여 중복이 발생하면 유효하지 않은 스도쿠이므로 완성할 수 없다.

## Algorithm
1. 변수를 초기화한다.
   - `boolean[][] rows` : `rows[i][j]`는 `i`번째 행의 숫자 `j`의 포함 여부를 나타낸다.
   - `boolean[][] cols` : `cols[i][j]`는 `i`번째 열의 숫자 `j`의 포함 여부를 나타낸다.
   - `boolean[][][] boxes` : `boxes[i][j][k]`는 `i`번째 행, `j`번째 열의 상자의 `k`의 포함 여부를 나타낸다.
2. `board`의 모든 셀을 순회하여 중복이 발생하면 `false`를 리턴, 아니라면 `true`를 리턴한다.

## Implementation
```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][][] boxes = new boolean[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int val = board[i][j] - '0' - 1;

                if (rows[i][val]) {
                    return false;
                }
                rows[i][val] = true;
                
                if (cols[j][val]) {
                    return false;
                }
                cols[j][val] = true;

                if (boxes[i / 3][j / 3][val]) {
                    return false;
                }
                boxes[i / 3][j / 3][val] = true;
            }
        }

        return true;
    }
}
```

## Complexity
- Time complexity: O(1)\
O(9 * 9) -> O(1)
- Space complexity: O(1)\
O(9 * 9 * 3) -> O(1)