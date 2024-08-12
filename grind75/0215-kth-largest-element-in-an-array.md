# [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

## Intuition
Quickselect 기법을 사용해 `k`번째 값을 빠르게 찾을 수 있다.

## Algorithm
- `findKthLargest` 메소드 : 배열 `nums`에서 `k`번째로 큰 값을 찾는다.
  - `quickSelect`를 호출해 배열의 전체 범위에서 `k`번째 큰 값을 찾아 리턴한다.
- `quickSelect` 메소드 : `k`번째 값을 주어진 범위 내에서 찾는다.
  - `partition` 메소드로 배열을 두 부분으로 나눈다.
  - `k`가 왼쪽 부분에 있으면 왼쪽 부분으로 탐색하고, 아닐 경우 오른쪽으로 탐색한다.
- `partition` 메소드 : 배열에서 주어진 범위를 두 부분으로 나눈다.
  - 범위의 중간 값을 `pivotValue`로 정한다.
  - 왼쪽 구간을 `pivotValue`보다 크거나 같은 값으로, 오른쪽 구간을 작거나 같은 값으로 나눈다.
  - 두 구간의 경계 인덱스를 리턴한다.

## Implementation
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(0, nums.length - 1, nums, k - 1);
    }

    private int quickSelect(int leftBound, int rightBound, int[] nums, int k) {
        if (leftBound == rightBound) {
            return nums[leftBound];
        }

        int[] partitionResult = partition(leftBound, rightBound, nums);

        int leftEnd = partitionResult[0];
        int rightStart = partitionResult[1];

        if (k <= leftEnd) {
            return quickSelect(leftBound, leftEnd, nums, k);
        } else {
            return quickSelect(rightStart, rightBound, nums, k);
        }
    }

    private int[] partition(int leftBound, int rightBound, int[] nums) {
        int pivotValue = nums[(rightBound + leftBound) / 2];

        int left  = leftBound;
        int right = rightBound;

        while (left <= right) {
            while (nums[left] > pivotValue) {
                left++;
            }
            while (nums[right] < pivotValue) {
                right--;
            }

            if (left < right) {
                swap(left++, right--, nums);
            } else if (left == right) {
                left++;
            }
        }

        return new int[] {right, left};
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이
- Time complexity: average O(n)
- Space complexity: average O(logn)
