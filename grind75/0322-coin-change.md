# [322. Coin Change](https://leetcode.com/problems/coin-change/)

## Intuition
동전들이 서로 나누어 떨어지지 않을 수도 있기 때문에 그리디 알고리즘이 아닌 DP 알고리즘으로 해결해야 한다.\
돈 i가 있을 때 최적의 값은 i - 동전들의 값 + 1 이다.

## Algorithm
1. 필요한 동전의 최소 개수를 저장할 `dp`배열을 선언.
2. 모든 돈 `i`에서의 최적의 값을 찾기 위해 1부터 `amount`까지 반복문을 순회한다.
   1. `dp[i]`를 최대값 + 1로 선언.
   2. `coins`를 순회하여 `dp[i]`를 최소 개수로 업데이트.
3. `dp[amount]`가 최대값보다 크다면 동전들로 구성할 수 없으니 `-1`을 리턴, 아니면 `dp[amount]`를 리턴.

## Implementation
```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;

            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
```

## Complexity
`m`은 `coins`의 길이, `n`은 `amount`.
- Time complexity: O(m * n)\
이중반복문으로 사용한 시간. 
- Space complexity: O(n)\
`dp`배열에서 사용한 공간.
