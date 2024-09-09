# [84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

## Intuition
배열을 앞에서부터 순회할 때, 현재 인덱스 `i`의 높이 `heights[i]`보다 높은 이전 인덱스들은 `i` 이후로 영향을 주지 않으므로 `heights[i]`보다 높은 `0 ~ i - 1` 인덱스의 높이를 `heights[i]`로 조정한다.

주어진 배열 `heights = {2,1,5,6,2,3}`을 순회하면 다음과 같다.
```
i = 0 => {2}
i = 1 => {1,1}
i = 2 => {1,1,5}
i = 3 => {1,1,5,6}
i = 4 => {1,1,2,2,2}
i = 5 => {1,1,2,2,2,3}
```
배열을 순회하면서 높이를 조정하면 위와 같이 높이가 오름차순으로 정렬된다. 영역 계산은 높이를 조정할 때 함께 계산한다.
```
i = 0 => {2}
i = 1 => {1,1}
```
`i`가 `1`일 때, 높이 `heights[i]`는 `1`이다. 이전 인덱스들을 역순으로 비교한다.\
이전 인덱스까지의 막대 높이는 `{2}`이고, 오름차순으로 정렬되어 있다. 현재 높이 `1`보다 높은 높이를 조정한다.\
`2`를 제거하면서 `2 * 1`의 영역을 얻을 수 있다.
```
i = 3 => {1,1,5,6}
i = 4 => {1,1,2,2,2}
```
`i`가 `4`일 때 `{5,6}`을 조정할 수 있다. `6`을 제거하면서 `6 * 1`의 영역을 얻고, `5`를 제거하면서 `5 * 2`의 영역을 얻는다. 
높이가 오름차순으로 정렬되어 있어 먼저 제거된 막대의 높이는 현재 제거되는 막대의 높이보다 크거나 같기 때문에 막대의 개수만큼 곱할 수 있다.
```
i = 5 => {1,1,2,2,2,3}
```
마지막으로 남은 영역을 계산하기 위해, 뒤에 높이가 `0`인 막대를 추가한다고 가정한다.\
`3`을 제거하면서 `3 * 1`, `2`를 제거하면서 `2 * 4`, `1`을 제거하면서 `1 * 6`의 영역을 얻는다.


위의 동작을 살펴보면, 높이를 비교할 때 늦게 들어온 막대를 먼저 비교하는 후입 선출 방식으로 진하게 된다. 이 방법에서는 `Stack` 자료구조가 적합하다.
또한 막대의 개수를 일일이 세는 대신, 인덱스로 길이를 계산하는 방법을 사용한다. `조정의 기준이 되는 인덱스 - 조정이 되는 인덱스의 이전 인덱스 - 1`은 막대의 개수를 구할 수 있다.
```
i = 3 => {1,2,3}
i = 4 => {1,4}
```
`i`가 `4`일 때 인덱스 `3`을 제거하면 길이는 `4 - 2 - 1`인 `1`이 되고, 인덱스 `2`를 제거한다면 `4 - 1 - 1`인 `2`가 된다.


이와 같은 방법으로 `O(n)`의 시간 복잡도로 문제를 효율적으로 해결할 수 있다.

## Implementation
```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            result = Math.max(result, calculateMaxArea(i, heights[i], heights, stack));
            stack.push(i);
        }

        result = Math.max(result, calculateMaxArea(n, 0, heights, stack));

        return result;
    }

    private int calculateMaxArea(int index, int minHeight, int[] heights, Stack<Integer> stack) {
        int maxArea = 0;

        while (!stack.isEmpty() && heights[stack.peek()] > minHeight) {
            int height = heights[stack.pop()];

            int length = index - (stack.isEmpty() ? -1 : stack.peek()) - 1;

            maxArea = Math.max(maxArea, height * length);
        }

        return maxArea;
    }
}
```

## Complexity
`n`은 배열 `heights`의 길이
- Time complexity: O(n)
- Space complexity: O(n)
