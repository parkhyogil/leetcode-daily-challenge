# [134. Gas Station](https://leetcode.com/problems/gas-station/)

## Intuition
주유소를 이동하면서 연료통에 가스가 음수가 되면 시작 주유소를 이동하면서 답을 찾는다.

## Algorithm
1. 변수를 초기화한다.
   - `n` : gas station 의 길이
   - `tank` : 연료통에 남은 가스량
   - `startIdx` : 시작 주유소 인덱스
   - `idx` : 현재 위치한 주유소 인덱스
2. 시작 주유소 인덱스인 `startIdx`를 `0`부터 `n - 1`까지 이동하며 아래를 반복한다.
   1. 연료통에 남은 가스가 음수이거나 한 바퀴를 돌 때까지 연료통에 현재 위치한 주유소의 가스를 더하고, 다음 주유소로 가기 위해 가스를 소모하고 이동한다.
   2. 연료통에 남은 가스가 0보다 크거나 같고 한 바퀴를 돌았다면 시작 인덱스를 리턴한다.
   3. 시작 주유소를 한 칸 앞으로 이동한다.
3. 한 바퀴를 돌 수 없으므로 `-1`을 리턴한다.

## Implementation
```java
class Solution {
   public int canCompleteCircuit(int[] gas, int[] cost) {
      int n = gas.length;

      int tank = 0;
      int startIdx = 0;
      int idx = 0;

      while (startIdx < n) {
         while (tank >= 0 && idx - startIdx < n) {
            tank += gas[idx % n] - cost[idx % n];
            idx++;
         }

         if (tank >= 0 && idx - startIdx == n) {
            return startIdx;
         }

         tank -= gas[startIdx] - cost[startIdx];
         startIdx++;
      }

      return -1;
   }
}
```

## Complexity
`n`은 `gas station`의 길이.
- Time complexity: O(n)\
- Space complexity: O(1)\

