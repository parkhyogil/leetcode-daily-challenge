# [528. Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/description/)

## Intuition
Prefix Sum과 Binary Search를 활용한다.\
예를 들어, 배열 `{3,1,4,5}`가 있을 때, Prefix Sum 배열은 `{0, 3, 4, 8, 13}`이 된다. 
이 Prefix Sum 배열에서 `0 ~ (maxSum - 1)` 사이의 랜덤한 값보다 작거나 같은 마지막 인덱스를 Binary Search로 찾으면, `{0 ~ 2, 3, 4 ~ 7, 8 ~ 12}` 범위의 가중치에 따라 각 인덱스를 다른 확률로 선택할 수 있다.

## Algorithm
- 생성자 : 주어진 배열 `w`로 `prefixSum` 배열을 만든다.
- `pickIndex` 메소드 : `0 ~ (maxSum - 1)`의 랜덤한 값으로 `binarySearch`를 호출해 인덱스를 리턴한다.
- `binarySearch` 메소드 : 주어진 값보다 작거나 같은 값이 나오는 마지막 인덱스를 리턴한다.

## Implementation

```java
class Solution {
    private int size, maxSum;
    private int[] prefixSum;

    public Solution(int[] w) {
        size = w.length;

        prefixSum = new int[size + 1];
        for (int i = 0; i < size; i++) {
            prefixSum[i + 1] = prefixSum[i] + w[i];
        }

        maxSum = prefixSum[size];
    }

    public int pickIndex() {
        return binarySearch((int) (Math.random() * maxSum));
    }

    private int binarySearch(int value) {
        int lo = 0;
        int hi = size;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (prefixSum[mid] > value) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return hi;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
```

## Complexity
`n`은 배열 `w`의 길이, `sum`은 배열 `w`의 총 합
- Time complexity: 
  - build : O(n)
  - pickIndex : O(log(sum))
- Space complexity: O(n)
