# [50. Pow(x, n)](https://leetcode.com/problems/powx-n/)

## Intuition
지수 법칙에 따라 `x^n`은 `(x^2)^(n/2)`로 표현할 수 있다. 
`n`이 기본 케이스인 `0`, `1`, `-1`이 될 때까지 재귀 호출을 하여 `O(logn)`의 시간 복잡도로 구현할 수 있다.

## Algorithm
- `myPow` 메소드 : `x`의 `n`승을 구하는 메소드
  1. `n == 0`이면 `1`을 반환하며 재귀 호출 종료
  2. `n == 1`이면 `x`을 반환하며 재귀 호출 종료
  3. `n == -1`이면 `x`의 역수를 반환하며 재귀 호출 종료
  4. `pow`에 `x`를 `x * x`로, `n`을 `n / 2`로 재귀 함수를 호출해 결과를 저장한다.
  5. `n`이 홀수일 경우, `n`을 `2`로 나눈 나머지가 `1`이라면 `pow`에 `x`를 곱하고, `-1`이라면 `x`의 역수를 곱한다.
  6. `pow`를 반환하며 함수를 종료한다.
  

## Implementation
```java
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n == -1) {
            return 1 / x;
        }

        double pow = myPow(x * x, n / 2);

        if (n % 2 != 0) {
            pow *= n > 0 ? x : 1 / x;
        }

        return pow;
    }
}
```

## Complexity
- Time complexity: O(logn)
- Space complexity: O(logn)
