# [31. Next Permutation](https://leetcode.com/problems/next-permutation/)

## Intuition
내림차순으로 정렬된 순열은 사전순으로 마지막 순열이 된다.
주어진 배열의 뒷부분부터 내림차순으로 정렬된 부분을 찾는다.
내림차순으로 정렬된 부분에서 가장 큰 값을 피크 인덱스라고 했을 때, 피크 인덱스의 왼쪽 인덱스부터 시작하는 순열의 다음 값을 찾아야 한다.
피크 인덱스의 왼쪽 인덱스의 다음 값을 내림차순으로 정렬된 부분에서 찾아 위치를 바꾸고, 내림차순 부분을 첫 번째 순열인 오름차순으로 정렬해주면 찾고 있는 다음 순열이 된다.



## Algorithm
1. `lastPeakIdx`에 순열의 마지막 내림차순으로 정렬된 부분의 첫 번째 인덱스를 저장한다.
2. `lastPeakIdx == 0`이라면 다음 순열이 존재하지 않으니 배열을 정렬하고 함수를 종료한다.
3. `nextGreaterIdx`에 `lastPeakIdx` 왼쪽 값의 다음 값 인덱스를 저장한다.
4. `lastPeakIdx - 1`이랑 `nextGreaterIdx` 값을 교환한다.
5. 순열의 마지막 내림차순 부분을 정렬하고 함수를 종료한다.

## Implementation
```java
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int lastPeakIdx = getLastPeakIdx(nums);

        if (lastPeakIdx == 0) {
            sort(nums, 0, n - 1);
            return;
        }

        int nextGreaterIdx = getNextGreaterIdx(nums, lastPeakIdx);

        swap(nums, lastPeakIdx - 1, nextGreaterIdx);

        sort(nums, lastPeakIdx, n - 1);
    }

    private int getNextGreaterIdx(int[] nums, int lastPeakIdx) {
        int res = nums.length - 1;

        while (nums[lastPeakIdx - 1] >= nums[res]) {
            res--;
        }

        return res;
    }

    private int getLastPeakIdx(int[] nums) {class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;

            int lastPeakIdx = getLastPeakIdx(nums);

            if (lastPeakIdx == 0) {
                sort(nums, 0, n - 1);
                return;
            }

            int nextGreaterIdx = getNextGreaterIdx(nums, lastPeakIdx);

            swap(nums, lastPeakIdx - 1, nextGreaterIdx);

            sort(nums, lastPeakIdx, n - 1);
        }

        private int getNextGreaterIdx(int[] nums, int lastPeakIdx) {
            int res = nums.length - 1;

            while (nums[lastPeakIdx - 1] >= nums[res]) {
                res--;
            }

            return res;
        }

        private int getLastPeakIdx(int[] nums) {
            int res = nums.length - 1;

            while (res - 1 >= 0 && nums[res - 1] >= nums[res]) {
                res--;
            }

            return res;
        }

        private void sort(int[] nums, int i, int j) {
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
        int res = nums.length - 1;

        while (res - 1 >= 0 && nums[res - 1] >= nums[res]) {
            res--;
        }

        return res;
    }

    private void sort(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이.
- Time complexity: O(n)
- Space complexity: O(1)

