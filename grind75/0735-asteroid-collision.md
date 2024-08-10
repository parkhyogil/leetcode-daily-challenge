# [735. Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)

## Intuition
스택 자료구조를 이용해 문제를 해결할 수 있다.\
왼쪽으로 향하는 소행성일 경우, 조건에 맞는 오른쪽으로 향하는 소행성을 제거한다.

## Algorithm
1. `Stack<Integer> stack`에 소행성을 저장한다
2. 배열을 순회하며 아래를 반복한다.
   1. `stack`이 비어있거나 현재 소행성이 오른쪽으로 향할 경우, `stack`에 소행성을 추가한다.
   2. 현재 소행성이 왼쪽으로 향할 경우 :
      1. 스택에 오른쪽으로 향하면서 현재 소행성보다 작은 소행성을 제거한다.
      2. 스택이 비어있거나 스택에 왼쪽으로 향하는 소행성만 있을 경우, 현재 소행성을 추가한다.
      3. 그렇지 않고, 스택에 오른쪽으로 향하는 소행성의 크기가 현재 소행성과 같다면 제거한다.
3. `int[] result`에 스택에 남아있는 소행성을 추가해 리턴한다.


## Implementation
```java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                }
            }
        }

        int[] result = new int[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
```

## Complexity
`n`은 배열 `asteroids`의 길이
- Time complexity: O(n)
- Space complexity: O(n)
