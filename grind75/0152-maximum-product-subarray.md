# [152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/)

## Intuition
현재 위치한 인덱스의 이전 인덱스를 마지막으로 하는 두 서브 배열을 관리한다.
하나는 최댓값을 가지는 서브 배열, 나머지는 최솟값을 가지는 서브 배열이다.
최솟값을 관리하는 이유는 현재 위치한 인덱스의 값과 서브 배열의 값이 음수일 경우 양수를 얻을 수 있기 때문이다.

## Algorithm
1. 변수를 초기화한다.
   - `max` : 추적한 서브 배열의 최댓값
   - `min` : 추적한 서브 배열의 최솟값
   - `res` : 결과값
2. 배열 `nums`를 순회하며 `max`, `min` 값을  현재 인덱스가 포함된 서브 배열의 최댓값과 최솟값으로 업데이트하고, `res`를 `max`와 비교하여 업데이트한다.
3. `res`를 리턴한다.

## Implementation
```java
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        double max = nums[0];
        double min = nums[0];
        double res = nums[0];

        for (int i = 1; i < n; i++) {
            double newMax = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            double newMin = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));

            max = newMax;
            min = newMin;

            res = Math.max(res, max);
        }

        return (int) res;
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이.
- Time complexity: O(n)
- Space complexity: O(1)
