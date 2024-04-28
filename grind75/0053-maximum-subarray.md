# [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/)

## Intuition
합이 음수가 된다면 subarray를 초기화하면서 최적의 답을 찾는다.

## Algorithm
```nums``` 배열을 순회한다
1. ```sum``` 이 0보다 작으면 0으로 초기화.
2. ```sum``` 에 값을 더하고 ```res``` 를 업데이트.

## Implementation
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int num : nums) {
            if (sum < 0) {
                sum = 0;
            }

            sum += num;
            res = Math.max(res, sum);
        }

        return res;
    }
}
```

## Complexity
- Time complexity: O(n)   
`nums` 배열을 한번 순회하기 때문에 시간복잡도는 O(n)이다.

- Space complexity: O(1)   
`sum`, `res` 변수를 저장하는 공간이 필요하기 때문에 공간복잡도는 O(1)이다.
