# [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)

## Intuition
하나의 레이어를 top, bottom, left, right로 나누고 top -> right -> bottom -> left 순으로 값을 저장하고 레이어를 줄여나간다.

## Algorithm
1. 결과를 저장할 `res` 선언.
2. `r1`에 현재 레이어의 첫 행, `r2`에 마지막 행, `c1`에 첫 열, `c2`에 마지막 열을 저장.
3. `r1 < r2 && c1 < c2`이라면 아래를 반복.
   1. top에 해당하는 (r1, c1) ~ (r1, c2 - 1) 저장.
   2. right에 해당하는 (r1, c2) ~ (r2 - 1, c2) 저장.
   3. bottom에 해당하는 (r2, c2) ~ (r2, c1 + 1) 저장.
   4. left에 해당하는 (r2, c1) ~ (r1 + 1, c1) 저장.
   5. `r1`, `c1`을 1 증가, `r2`, `c2`를 1 감소시켜 레이어를 축소.
4. 마지막으로 행이나 열이 한 줄 남았다면 추가하고 `res` 리턴.

## Implementation
```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;

        while (r1 < r2 && c1 < c2) {
            for (int i = c1; i < c2; i++) {
                res.add(matrix[r1][i]);
            }
            for (int i = r1; i < r2; i++) {
                res.add(matrix[i][c2]);
            }
            for (int i = c2; i > c1; i--) {
                res.add(matrix[r2][i]);
            }
            for (int i = r2; i > r1; i--) {
                res.add(matrix[i][c1]);
            }

            r1++;
            r2--;
            c1++;
            c2--;
        }
        
        if (r1 == r2) {
            for (int i = c1; i <= c2; i++) {
                res.add(matrix[r1][i]);
            }
        } else if (c1 == c2) {
            for (int i = r1; i <= r2; i++) {
                res.add(matrix[i][c1]);
            }
        }

        return res;
    }
}
```

## Complexity
`n`은 `matrix`의 셀의 개수
- Time complexity: O(n)\
`matrix`의 모든 셀을 한번 순회.
- Space complexity: O(1)\
결과를 저장하는 공간을 제외하고 사용한 공간은 O(1).
