# [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

## Intuition
배열을 앞에서부터 순회하면서 길이가 `k`인 윈도우를 관리한다.
새로운 요소를 윈도우에 추가할 때, 새 요소보다 값이 작은 앞의 요소들은 필요 없으므로 제거한다.
작은 요소를 제거하면서 윈도우를 관리하면, 윈도우는 내림차순으로 정렬되며 가장 큰 값이 항상 윈도우의 앞에 위치하게 된다.\
이 방식으로 윈도우에서 가장 큰 값을 쉽게 찾을 수 있다.

이 과정에서 윈도우의 양 끝에서 데이터에 접근하므로, **Deque** 자료구조를 이용하면 효율적으로 구현할 수 있다.

예를 들어, 다음과 같은 입력이 주어졌을 때
```
nums = [1,3,-1,-3,5,3,6,7], k = 3
```
진행 과정은 다음과 같다. 먼저 k - 1개의 요소를 Deque에 삽입한다.
```
i = 0;  deque = {1};
i = 1;  deque = {3};
```
그리고 인덱스 k - 1부터 결과를 기록한다.
```
i = 2;  deque = {3, -1};        result = {3};
i = 3;  deque = {3, -1, -3};    result = {3, 3};
i = 4;  deque = {5};            result = {3, 3, 5};
i = 5;  deque = {5, 3};         result = {3, 3, 5, 5};
i = 6;  deque = {6};            result = {3, 3, 5, 5, 6};
i = 7;  deque = {7};            result = {3, 3, 5, 5, 6, 7};
```
이와 같이 **Deque** 자료구조를 활용하면, 문제를 효율적으로 해결할 수 있다.

## Implementation
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] result = new int[n - k + 1];

        for (int i = k - 1; i < n; i++) {
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            result[i - (k - 1)] = nums[deque.peekFirst()];
        }

        return result;
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이
- Time complexity: O(n)
- Space complexity: O(k)
