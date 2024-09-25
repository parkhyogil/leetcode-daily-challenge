# [632. Smallest Range Covering Elements from K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/)

## Intuition
정렬된 각 리스트에서 최소 하나 이상의 요소를 포함하려면, 각 리스트의 첫 번째 인덱스를 모두 추적한다. 이를 통해 첫 번째 범위를 확인할 수 있다.

그 후, 가장 작은 값을 갖는 인덱스를 다음 인덱스로 이동시켜 범위를 업데이트한다.

각 리스트의 인덱스가 끝에 도달하기 전까지 이 과정을 반복하면 모든 범위를 확인할 수 있다.

**Priority Queue** 자료구조를 사용하면 가장 작은 값을 갖는 인덱스를 빠르게 찾고, 다음 인덱스를 빠르게 업데이트할 수 있다.

## Implementation
```java
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums.get(a[0]).get(a[1]), nums.get(b[0]).get(b[1])));

        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{i, 0});
            maxVal = Math.max(maxVal, nums.get(i).get(0));
        }

        int[] result = new int[]{-100000, 100000};

        while (true) {
            int[] pos = minHeap.poll();
            int minVal = nums.get(pos[0]).get(pos[1]);

            if (maxVal - minVal < result[1] - result[0]) {
                result[0] = minVal;
                result[1] = maxVal;
            }

            pos[1]++;

            if (pos[1] == nums.get(pos[0]).size()) {
                break;
            }

            maxVal = Math.max(maxVal, nums.get(pos[0]).get(pos[1]));
            minHeap.offer(pos);
        }

        return result;
    }
}
```

## Complexity
`n`은 `nums`의 길이, `m`은 `nums[i]`의 최대 길이
- Time complexity: O(n * m * logn)
- Space complexity: O(n)
