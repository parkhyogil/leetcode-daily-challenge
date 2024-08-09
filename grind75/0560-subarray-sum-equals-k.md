# [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/description/)

## Intuition
인덱스 `i`까지의 합이 `x`, 그리고 인덱스 `j`까지의 합이 `x - k`라면 `(j < i)`, `j + 1`부터 `i`까지의 구간은 합이 `k`인 서브어레이가 된다.
배열의 앞에서부터 합을 계산하고, 각 합의 개수를 저장하여 빠르게 결과를 계산할 수 있다.

## Algorithm
1. 변수를 초기화한다.
   - `Map<Integer, Integer> prefixSumCountMap` : 특정 prefix sum이 배열에 몇 번 나타났는지를 저장한다.
   - `int prefixSum` : 현재 인덱스까지의 prefix sum
   - `int result` : 합이 `k`인 서브어레이의 수
2. `prefixSumCountMap`에 합이 0인 서브어레이가 1개 있다고 추가한다.
3. 배열을 순회하며 아래 작업을 반복한다.
   1. 배열의 현재 인덱스 값 `num`을 `prefixSum`에 추가한다.
   2. 합이 `prefixSum - k`인 서브어레이의 개수를 `result`에 추가한다.
   3. 현재 `prefixSum`을 `prefixSumCountMap`에 1 증가시켜 저장한다.
4. `result`를 리턴한다.

## Implementation
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCountMap = new HashMap<>();
        int prefixSum = 0;
        int result = 0;

        prefixSumCountMap.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            if (prefixSumCountMap.containsKey(prefixSum - k)) {
                result += prefixSumCountMap.get(prefixSum - k);
            }

            prefixSumCountMap.put(prefixSum, 1 + prefixSumCountMap.getOrDefault(prefixSum, 0));
        }

        return result;
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이.
- Time complexity: O(n)
- Space complexity: O(n)
