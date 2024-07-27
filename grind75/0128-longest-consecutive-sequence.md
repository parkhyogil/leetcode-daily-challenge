# [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)

## Intuition
Union-Find 기법으로 연속된 값들을 그룹화하여 가장 큰 그룹의 크기를 찾는다.\
경로 압축을 통해 상수 시간에 가깝게 동작하여 O(n) 시간 복잡도로 구현할 수 있다.

## Algorithm
1. 배열 `nums`를 순회하며 현재 값과 연속된 값이 있다면 union 연산을 수행한다.
2. 그룹의 크기 중 최댓값을 리턴한다.

## Implementation
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> rootOf = new HashMap<>();
        Map<Integer, Integer> sizeOf = new HashMap<>();

        int res = 0;

        for (int num : nums) {
            if (rootOf.containsKey(num)) {
                continue;
            }
            
            rootOf.put(num, num);
            sizeOf.put(num, 1);

            if (rootOf.containsKey(num - 1)) {
                union(num, num - 1, rootOf, sizeOf);
            }
            if (rootOf.containsKey(num + 1)) {
                union(num, num + 1, rootOf, sizeOf);
            }
        }

        for (int num : rootOf.keySet()) {
            res = Math.max(res, sizeOf.get(findRoot(num, rootOf)));
        }

        return res;
    }

    private void union(int a, int b, Map<Integer, Integer> rootOf, Map<Integer, Integer> sizeOf) {
        a = findRoot(a, rootOf);
        b = findRoot(b, rootOf);

        if (a < b) {
            rootOf.put(b, a);
            sizeOf.put(a, sizeOf.get(a) + sizeOf.get(b));
        } else {
            rootOf.put(a, b);
            sizeOf.put(b, sizeOf.get(a) + sizeOf.get(b));
        }
    }

    private int findRoot(int child, Map<Integer, Integer> rootOf) {
        if (child == rootOf.get(child)) {
            return child;
        }

        rootOf.put(child, findRoot(rootOf.get(child), rootOf));

        return rootOf.get(child);
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이
- Time complexity: O(n)
- Space complexity: O(n)
