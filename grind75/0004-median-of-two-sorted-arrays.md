# [4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/description/)

## Intuition
정렬된 두 배열을 병합하여 중앙값을 찾는 방법보다 더 빠른 방법을 찾아야 한다.

병합된 배열의 길이는 두 배열의 길이의 합이며, 배열을 반으로 나누었을 때 중앙값이 포함된 왼쪽 부분의 길이는 `(총 길이 + 1) / 2`, 오른쪽 부분의 길이는 나머지가 된다.
왼쪽 부분을 만들기 위해 `nums1`에서 `i`개의 요소를 선택하면, 나머지 요소는 `nums2`에서 선택한다.


요소를 선택하여 나눠진 두 부분이 정렬된 상태가 되기 위해서는 왼쪽 부분의 값들은 오른쪽 부분의 값들보다 작거나 같아야한다.
즉, 왼쪽 부분에서 `nums1`의 최댓값은 오른쪽 부분에서 `nums2`의 최솟값보다 작거나 같아야하고, 왼쪽 부분에서 `nums2`의 최댓값은 오른쪽 부분에서 `nums1`의 최솟값보다 작거나 같아야한다.

왼쪽 부분에서 `nums2`의 최댓값이 오른쪽 부분에서 `nums1`의 최솟값보다 크다면, `nums2`의 큰 값을 오른쪽으로 보내기 위해 `nums1`의 선택 개수를 늘려야 한다.
반대로 왼쪽 부분에서 `nums1`의 최댓값이 오른쪽 부분에서 `nums2`의 최솟값보다 크다면, `nums2`의 작은 값을 왼쪽으로 가져오기 위해 `nums1`의 선택 개수를 줄여야 한다.

다음과 같은 배열이 주어졌을 때
```
nums1 = {2,8,9,11}
nums2 = {1,3,8,10,14}
```
`nums1`에서 선택한 요소의 개수에 따른 최댓값과 최솟값은 아래와 같다.
```
nums1에서 0개 선택 -> nums1 = MIN  /  nums2 = 14  |  nums1 = 2    /  nums2 = MAX  
nums1에서 1개 선택 -> nums1 = 2    /  nums2 = 10  |  nums1 = 8    /  nums2 = 14   
nums1에서 2개 선택 -> nums1 = 8    /  nums2 = 8   |  nums1 = 9    /  nums2 = 10
nums1에서 3개 선택 -> nums1 = 9    /  nums2 = 3   |  nums1 = 11   /  nums2 = 8
nums1에서 4개 선택 -> nums1 = 11   /  nums2 = 1   |  nums1 = MAX  /  nums2 = 3
```
`nums1`에서 `0 ~ 1`개를 선택한 경우, 왼쪽 `nums2`의 최댓값이 오른쪽 `nums1`의 최솟값보다 크기 때문에 선택 개수를 늘려야한다.

`2`개를 선택한 경우, 왼쪽 `nums1`의 최댓값이 오른쪽 `nums2`의 최솟값보다 작거나 같고, 왼쪽 `nums2`의 최댓값이 오른쪽 `nums1`의 최솟값보다 작거나 같기 때문에 정렬이 된 상태다.

`3 ~ 4`개를 선택한 경우, 왼쪽 `nums1`의 최댓값이 오른쪽 `nums2`의 최솟값보다 크기 때문에 선택 개수를 줄여야한다.

정리해보면, `nums1`의 길이를 `m`, 배열이 정렬되는 요소의 개수를 `i`라고 했을 때, `0 ~ (i - 1)`개를 선택했다면 선택 개수를 늘려야 하고, `(i + 1) ~ m`개를 선택했다면 선택 개수를 줄여야 한다.

이 과정에서 `Binary Search` 기법을 사용할 수 있다.찾는 값은 `i`, 찾는 범위는 `0 ~ m`가 된다. 
왼쪽 `nums2`의 최댓값이 오른쪽 `nums1`의 최솟값보다 크다면, 선택 개수를 늘리기 위해 범위를 오른쪽으로 이동시키고, 반대로 왼쪽 `nums1`의 최댓값이 오른쪽 `nums2`의 최솟값보다 크다면 범위를 줄이기 위해 왼쪽으로 이동하면서 `i`를 찾을 수 있다.

이렇게 `Binary Search`를 통해 배열을 병합하는 방법보다 효율적으로 중앙값을 찾을 수 있다.
 
## Implementation
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int length = m + n;

        int sizeLeftPart = (length + 1) / 2;

        int low = 0;
        int high = m;

        while (low <= high) {
            int partitionSizeArray1 = (low + high) / 2;
            int partitionSizeArray2 = sizeLeftPart - partitionSizeArray1;

            int minValueArray1 = partitionSizeArray1 == 0 ? Integer.MIN_VALUE : nums1[partitionSizeArray1 - 1];
            int maxValueArray1 = partitionSizeArray1 == m ? Integer.MAX_VALUE : nums1[partitionSizeArray1];

            int minValueArray2 = partitionSizeArray2 == 0 ? Integer.MIN_VALUE : nums2[partitionSizeArray2 - 1];
            int maxValueArray2 = partitionSizeArray2 == n ? Integer.MAX_VALUE : nums2[partitionSizeArray2];

            if (minValueArray2 > maxValueArray1) {
                low = partitionSizeArray1 + 1;
            } else if (minValueArray1 > maxValueArray2) {
                high = partitionSizeArray1 - 1;
            } else {
                if (length % 2 == 1) {
                    return Math.max(minValueArray1, minValueArray2);
                } else {
                    return (Math.max(minValueArray1, minValueArray2) + Math.min(maxValueArray1, maxValueArray2)) / 2.0;
                }
            }
        }

        return -1.0;
    }
}
```

## Complexity
`m`은 `nums1`의 길이, `n`은 `nums2`의 길이
- Time complexity: O(logm)
- Space complexity: O(1)
