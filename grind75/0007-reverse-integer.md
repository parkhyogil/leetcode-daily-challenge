# [7. Reverse Integer](https://leetcode.com/problems/reverse-integer/description/)

## Intuition
주어진 정수 `x`가 `0`이 될 때까지, 결과에 `x`를 `10`으로 나눈 나머지를 붙이고 `x`를 `10`으로 나눈다.

## Algorithm
1. `int result`에 결과를 저장한다.
2. `x`가 `0`이 될 때까지 아래를 반복한다.
   1. `digit`에 `x`를 `10`으로 나눈 나머지를 저장한다.
   2. 다음 결과가 오버플로우가 된다면 `0`을 반환하며 함수를 종료한다.
   3. `result`에 `digit`를 이어 붙인다.
   4. `x`를 `10`으로 나눈다.
3. `result`를 반환한다.

## Implementation
```java
class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;

            if (willOverflow(result, digit)) {
                return 0;
            }

            result = result * 10 + digit;
            x /= 10;
        }

        return result;
    }

    private boolean willOverflow(int result, int digit) {
        return (result * 10 + digit) / 10 != result;
    }
}
```

## Complexity
- Time complexity: O(logx)

- Space complexity: O(1)
