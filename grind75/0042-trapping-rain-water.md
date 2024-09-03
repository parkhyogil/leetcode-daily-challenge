# [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)

## Intuition
비가 고이기 위해서는 양쪽에 자신보다 더 높은 인덱스가 있어야 한다.\
스택 자료구조를 사용하여 배열을 앞에서부터 순회하면서 지나온 인덱스들을 역순으로 효율적으로 비교한다. 
스택 안의 인덱스는 높이에 따라 내림차순으로 관리되며, 배열을 순회할 때 현재 인덱스의 높이가 스택의 마지막 인덱스의 높이보다 높다면, 이 마지막 인덱스는 양쪽에 자신보다 높은 상태를 갖게 된다.

## Algorithm
1. `result`에 결과를 저장한다.
2. `stack`에 인덱스를 저장한다. `stack` 안에 남아있는 인덱스의 값은 높이가 내림차순으로 관리된다.
3. `height`를 순회하며 아래를 반복한다.
   1. 현재 인덱스 `i` 높이가 `stack`의 마지막 인덱스의 높이보다 크거나 같다면 고인 비의 양을 추가할 수 있다.
      1. `stack`에서 가장 낮은 높이를 꺼내 `bottomHeight`에 할당한다.
      2. `stack`이 비었다면 while loop을 종료한다.
      3. `i`와 `stack`에서 그 다음 낮은 높이의 인덱스 사이를 `length`에 할당한다.
      4. `i`의 높이와 `stack`에서 그 다음 낮은 높이 중 최솟값을 `sideHeight`에 할당한다.
      5. `length * (sideHeight - bottomHeight)`는 고인 비의 양이 된다. `result`에 더한다.
   2. `stack`에 인덱스 `i`를 추가한다.
4. `result`를 반환한다.

## Implementation
```java
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int bottomHeight = height[stack.pop()];

                if (stack.isEmpty()) {
                    break;
                }

                int length = i - stack.peek() - 1;
                int sideHeight = Math.min(height[i], height[stack.peek()]);

                result += length * (sideHeight - bottomHeight);
            }

            stack.push(i);
        }

        return result;
    }
}
```

## Complexity
`n`은 배열 `height`의 길이
- Time complexity: O(n)
- Space complexity: O(n)
