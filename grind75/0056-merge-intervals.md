# [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)

## Intuition
인터벌의 시작값으로 정렬했을 때, 앞에 있는 인터벌의 끝이 뒤에 있는 인터벌의 시작과 같거나 크다면 병합할 수 있다.

## Algorithm
1. `intervals`를 인터벌의 시작값을 기준으로 오름차순으로 정렬한다.
2. 병합된 인터벌을 저장할 `merged` 선언.
3. `intervals`를 순회하여 `merge`의 마지막 인터벌의 끝이 현재 인터벌의 시작보다 작으면 병합할 수 없으니 새로 추가.
4. 병합할 수 있다면 `merge`의 마지막 인터벌의 끝을 현재 인터벌의 끝과 비교해 최대값으로 변경.
5. 결과를 리턴.

## Implementation
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
```

## Complexity
- Time complexity: O(nlogn)\
`intervals`를 정렬하는데 사용한 시간. 
- Space complexity: O(n)\
병합된 인터벌을 저장한 공간. 
