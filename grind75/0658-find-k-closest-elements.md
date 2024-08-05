# [658. Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/description/)

## Intuition
배열의 앞에서부터 `k` 크기의 서브어레이에서 배열의 값과 `x`의 차이의 절대값의 합이 가장 작은 첫 인덱스를 찾는다.

## Algorithm
1. 변수를 초기화한다.
   - `int startIdx` : 절대값의 합이 가장 작은 서브어레이의 시작 인덱스
   - `int sum` : 서브어레이의 절대값의 합
   - `int minSum` : 서브어레이의 절대값의 합 중 최솟값
2. `sum`에 처음 `k`개의 배열 값과 `x`의 차이의 절대값을 더한다.
3. 배열을 순회하며 서브어레이의 절대값의 합 중 최솟값을 갖는 시작 인덱스를 찾는다.
4. `List<Integer> result`를 초기화한다.
5. `startIdx`부터 `k`의 배열 값을 `result`에 저장하고 리턴한다.

## Implementation
```java
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        int startIdx = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += Math.abs(x - arr[i]);
        }

        int minSum = sum;

        for (int i = 1; i <= n - k; i++) {
            sum += Math.abs(x - arr[i + k - 1]) - Math.abs(x - arr[i - 1]);

            if (sum < minSum) {
                startIdx = i;
                minSum = sum;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = startIdx; i < startIdx + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
```

## Complexity
`n`은 배열 `arr`의 길이
- Time complexity: O(n + k)
- Space complexity: O(1)
