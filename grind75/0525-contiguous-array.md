# [525. Contiguous Array](https://leetcode.com/problems/contiguous-array/)

## Intuition
구간 합 알고리즘을 이용해 문제를 해결한다.\
`0`과 `1`의 빈도를 합으로 관리한다. 현재 인덱스까지의 합이 이전에 등장했었다면, 최초로 등장했던 인덱스와 현재 인덱스의 사이는 합이 0이 되는 서브어레이가 된다.

## Algorithm
1. 변수를 초기화한다.
   - `int n` : 배열 `nums`의 길이
   - `Map<Integer, Integer> indexOfSum` : 해당 합이 처음 나온 인덱스를 저장하는 해시맵
   - `int sum` : 현재 인덱스까지의 합
   - `int res` : 결과값
2. 배열을 순회한다.
   1. 현재 값이 `0`이면 `sum`을 감소, `1`이라면 증가시킨다.
   2. 현재까지의 합이 전에 나왔던 값이라면 `res`를 업데이트한다.
   3. 처음 나온 값이라면 `indexOfSum`에 현재 합을 키로, 인덱스를 값으로 저장한다.
3. `res`를 리턴한다.

## Implementation
```java
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> indexOfSum = new HashMap<>();
        indexOfSum.put(0, -1);

        int sum = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if (indexOfSum.containsKey(sum)) {
                res = Math.max(res, i - indexOfSum.get(sum));
            } else {
                indexOfSum.put(sum, i);
            }
        }

        return res;
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이
- Time complexity: O(n)
- Space complexity: O(n)
