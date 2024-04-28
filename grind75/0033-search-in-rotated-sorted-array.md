# [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

## Intuition
정렬된 배열이 회전됐을 때 배열을 반으로 나눴을 때 한쪽은 정렬이 된 상태이고 나머지 한쪽은 회전된 형태다.\
일반적인 이진탐색과 같이 배열을 반으로 나눠 정렬된 부분을 찾고 찾는 값이 정렬된 부분에 없을 경우에 회전된 쪽에서 찾으면 된다.\

## Algorithm
1. `left`에 배열의 시작, `right`에 배열의 끝을 지정한다.
2. `left`가 `right`보다 작거나 같을 때 다음을 반복.
   1. `mid`에 `left`와 `right` 가운데를 지정.
   2. `nums[mid]`가 `target`과 같다면 `mid` 리턴.
   3. 배열의 왼쪽이 정렬된 상태일 때 `target`이 왼쪽에 있을 경우 `right`를 `mid - 1`로, 아니라면 `left`를 `mid + 1`로 변경.
   4. 배열의 오른쪽이 정렬된 상태일 때 `target`이 오른쪽에 있을 경우 `left`를 `mid + 1`로, 아니라면 `right`를 `mid - 1`로 변경.
3. `target`이 존재하지 않으니 -1을 리턴.

## Implementation
```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
```

## Complexity
`n`은 `nums`의 길이.
- Time complexity: O(logN)\
배열의 길이를 반으로 나눠가며 탐색.

- Space complexity: O(1)\
`left`, `right`, `mid`에서 사용한 공간.
