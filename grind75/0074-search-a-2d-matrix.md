# [74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

## Intuition
각 행이 오름차순으로 정렬된 이차원 배열이 주어진다.
행의 첫 숫자가 이전 행의 마지막 숫자보다 크기 때문에 오름차순으로 정렬된 일차원 배열로 생각할 수 있다.\
이진 탐색으로 `O(log(m * n))`의 시간 복잡도로 문제를 해결할 수 있다.

## Algorithm
1. 변수를 초기화한다.
   - `int m` : `matrix`의 행
   - `int n` : `matrix`의 열
   - `int lo` : 일차원 배열의 첫 번째 인덱스
   - `int hi` : 일차원 배열의 마지막 인덱스
2. `lo <= hi`라면 아래를 반복한다.
   1. `mid`는 `lo`와 `hi`의 중간이 된다.
   2. 일차원 배열에서 인덱스 `mid`의 값을 `value`에 저장한다.
   3. `value`가 `target`과 같다면 `true`를 반환한다.
   4. `value`가 `target`보다 작다면 배열의 오른쪽에서 탐색하기 위해 `lo`를 `mid + 1`로 변경한다.
   5. `value`가 `target`보다 크다면 배열의 왼쪽에서 탐색하기 위해 `hi`를 `mid - 1`로 변경한다.
3. 배열에서 `target`을 찾지 못했으니 `false`를 반환한다.

## Implementation
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lo = 0;
        int hi = m * n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            int value = matrix[mid / n][mid % n];

            if (value == target) {
                return true;
            } else if (value < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }
}
```

## Complexity
`m`은 `matrix`의 행, `n`은 열
- Time complexity: O(log(m * n))
- Space complexity: O(1)
