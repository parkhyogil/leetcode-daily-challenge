# [55. Jump Game](https://leetcode.com/problems/jump-game/)

## Intuition
이전 인덱스까지의 점프 길이를 추적하여 현재 인덱스에서의 점프 길이를 구하고, 배열의 끝까지 도달한다.

## Algorithm
1. `int jumpLength`를 `1`로 초기화한다.
2. 배열 `nums`를 순회하며 아래 작업을 반복한다.
   1. 이전 인덱스에서의 점프 길이가 현재 인덱스에 닿지 못하면 `false`를 리턴한다.
   2. 현재 인덱스에서의 점프 길이는 이전 인덱스에서의 점프 길이에서 1 감소시킨 값과 현재 인덱스의 점프 길이 중 최댓값이다.
3. `nums`의 모든 인덱스를 순회했다면 `true`를 리턴한다.

## Implementation
```java
class Solution {
    public boolean canJump(int[] nums) {
        int jumpLength = 1;

        for (int length : nums) {
            if (jumpLength == 0) {
                return false;
            }

            jumpLength = Math.max(jumpLength - 1, length);
        }

        return true;
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이
- Time complexity: O(n)

- Space complexity: O(1)
