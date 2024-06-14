# [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

## Intuition
배열의 양 끝에 포인터를 두고 영역을 업데이트한 뒤에 높이가 낮은 쪽을 줄여오면서 답을 찾는다.

## Algorithm
1. 변수를 초기화한다.
    - `left`는 현재 영역의 시작
    - `right`는 현재 영역의 끝
    - `res`는 결과
2. `left <= right`가 참이라면 아래를 반복한다.
   1. `res`를 현재 영역과 비교하여 최대값으로 업데이트한다.
   2. `height[left] < height[right]`이 참이라면 `left`를 증가, 반대라면 `right`를 감소시킨다.
3. `res`를 리턴한다.

## Implementation
```java
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int left = 0;
        int right = n - 1;

        int res = 0;

        while (left <= right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
```

## Complexity
`n`은 `height`의 길이.
- Time complexity: O(n)\
`height`배열을 한번 순회한다.

- Space complexity: O(1)\
상수 공간을 사용한다.
