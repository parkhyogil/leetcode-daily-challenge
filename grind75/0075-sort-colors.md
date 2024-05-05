# [75. Sort Colors](https://leetcode.com/problems/sort-colors/)

## Algorithm
1. `left`에 마지막 0의 위치, `right`엔 마지막 2의 위치를 저장.
2. `nums`를 순회한다.
   1. `num`이 0일 경우 마지막 0의 위치 다음인 `left + 1`과 `i`를 바꾸고 `i`를 1 증가.
   2. 1일 경우 `i`를 1 증가.
   3. 2일 경우 마지막 2의 위치 다음인 `right - 1`과 `i`를 바꾼다. `i`를 증가시키지 않는 이유는 바꾼 값을 모르기 때문에 한번 더 확인하기 위해서다.

## Implementation
```java
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int left = -1;
        int right = n;

        for (int i = 0; i < right; ) {
            int num = nums[i];

            if (num == 0) {
                swap(i++, ++left, nums);
            } else if (num == 1) {
                i++;
            } else {
                swap(i, --right, nums);
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```

## Complexity
`n`은 `nums`의 길이.
- Time complexity: O(n)\
`nums`를 한번 순회한다.
- Space complexity: O(1)\
상수 공간을 사용한다.
