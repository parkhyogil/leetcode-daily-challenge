# [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/description/)

## Algorithm
1. `sum`에 `nums`의 모든 값을 더한다.
2. `sum % 2 == 1`이라면 나눌 수 없으니 `false` 리턴.
3. `target`은 `sum / 2`.
4. 재귀함수로 dp table을 완성하여 `memo[0][target]` 리턴.
   - `target == 0`이라면 `true` 리턴.
   - `target < 0`이라면 `false` 리턴.
   - 이미 계산된 `memo[idx][target]`이라면 값을 리턴.
   - `memo[idx][target]`은 현재 값을 선택한 `memo[idx + 1][target - nums[idx]]`와 선택하지 않고 넘어간 `memo[idx + 1][target]`의 `||` 연산.

## Implementation
```java
class Solution {
   public boolean canPartition(int[] nums) {
      int sum = 0;

      for (int num : nums) {
         sum += num;
      }

      if (sum % 2 == 1) {
         return false;
      }

      int target = sum / 2;

      return recur(0, target, nums, new int[nums.length][target + 1]);
   }

   private boolean recur(int idx, int target, int[] nums, int[][] memo) {
      if (target == 0) {
         return true;
      }

      if (target < 0 || idx == nums.length) {
         return false;
      }

      if (memo[idx][target] != 0) {
         return memo[idx][target] == 1;
      }

      memo[idx][target] = recur(idx + 1, target - nums[idx], nums, memo) || recur(idx + 1, target, nums, memo) ? 1 : -1;

      return memo[idx][target] == 1;
   }
}
```

## Complexity
`n`은 `nums`의 길이, `sum`은 `nums`의 합.
- Time complexity: O(n·sum)\
dp table을 완성하는데 걸린 시간.
- Space complexity: O(n·sum)\
dp table에서 사용한 공간.
