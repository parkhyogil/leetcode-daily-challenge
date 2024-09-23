# [41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/description/)

## Intuition
배열의 길이가 `n`이라면, 배열의 값 중 `1 ~ n` 사이의 값을 인덱스 `0 ~ n - 1`와 연결할 수 있다.

그리고 배열을 앞에서부터 순회하며, 배열의 값과 인덱스가 일치하지 않는 부분이 가장 작은 미싱 넘버가 된다.

배열 `{3,1,2,2,-10}`가 주어졌을 때 진행 과정은 아래와 같다.
```
i = 0; num = 3; swap(0, 3 - 1) => {2,1,3,2,-10};
```
`i`가 `0`일 때 값은 `3`이다. `3`을 인덱스 `2`와 연결하기 위해 인덱스 `0`과 `2`의 값을 교환한다.
```
i = 0; num = 2; swap(0, 2 - 1) => {1,2,3,2,-10};
```
교환 후 값은 `2`이다. `2`를 인덱스 `1`과 연결하기 위해 인덱스 `0`과 `1`의 값을 교환한다.
```
i = 0; num = 1; nums[i] = 1; nums[nums[i] = 1] = 1; skip;
```
교환 후 값은 `1`이다. 연결되었으니 다음 인덱스로 넘어간다.
```
i = 1; num = 2; nums[i] = 2; nums[nums[i] - 1] = 2; skip;
i = 2; num = 3; nums[i] = 3; nums[nums[i] - 1] = 3; skip;
```
인덱스 `1`,`2`는 연결되었으니 다음 인덱스로 넘어간다.
```
i = 3; num = 2; nums[i] = 2; nums[nums[i] = 1] = 2; skip;
```
`i`가 `3`일 때 값은 `2`이다. 인덱스 `1`은 이미 `2`와 연결되었으니 넘어간다.
```
i = 4; num = -10; -10 < 1; skip;
```
`i`가 `4`일 때 값은 `-10`이다. `1 ~ n` 사이의 값이 아니므로 넘어간다.

최종적으로 배열은 `{1, 2, 3, 2,-10}`가 된다. 일치하지 않는 인덱스는 `3`이므로 가장 작은 미싱 넘버는 `4`가 된다.


## Implementation
```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == i + 1) {
                continue;
            }

            while (1 <= nums[i] && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1, nums);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] != i) {
                return i;
            }
        }

        return n + 1;
    }

    void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이
- Time complexity: O(n)
- Space complexity: O(1)
