# [189. Rotate Array](https://leetcode.com/problems/rotate-array/)

## Intuition
임의의 인덱스 `i`에서 값을 바꿀 때 `i`의 값은 `(i + k) % n` 자리에 들어가게 된다. 
그 다음은 `(i + 2k) % n`, 다음은 `(i + 3k) % n`으로, k를 더해가며 값을 바꿔가다 `xk`가 `n`의 배수가 될 때 첫 인덱스 `i`로 돌아온다.\
배열의 모든 값을 이동할 때까지 사이클의 시작 인덱스를 옮겨가며 사이클 내의 값들을 한 칸씩 이동해 `O(n)`의 시간 복잡도와 `O(1)`의 공간 복잡도로 문제를 해결할 수 있다.

## Algorithm
1. 변수를 초기화한다.
   - `int n` : 배열 `nums`의 길이
   - `int start` : 사이클 시작 인덱스
   - `int swapCount` : 배열에서 값 교환이 일어난 횟수
2. `k`를 조정한다.
3. `swapCount`가 `n`보다 작다면 아래를 반복한다.
   1. `idx`에 `start`를 할당한다.
   2. `tmp`에 사이클 첫 번째 값을 임시 저장한다.
   3. 현재 사이클을 돌며 값을 한 칸씩 이동한다.
   4. 마지막 자리에 사이클 첫 번째 값을 저장한다.
   5. 사이클 시작 인덱스 `start`를 `1` 증가시킨다.

## Implementation
```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int swapCount = 0;

        k %= n;

        while (swapCount < n) {
            int idx = start;
            int tmp = nums[idx];

            while ((idx + n - k) % n != start) {
                nums[idx] = nums[(idx + n - k) % n];
                idx = (idx + n - k) % n;
                swapCount++;
            }

            nums[idx] = tmp;
            swapCount++;

            start++;
        }
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이
- Time complexity: O(n)
- Space complexity: O(1)
