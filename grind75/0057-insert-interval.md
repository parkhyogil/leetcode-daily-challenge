# [57. Insert Interval](https://leetcode.com/problems/insert-interval/description/)

## Intuition
intervals 배열을 3구간으로 나눌 수 있다.
1. 병합할 수 없는 왼쪽.
    * 현재 인터벌의 끝이 새 인터벌의 시작보다 작으면 병합할 수 없다.
2. 병합할 수 없는 오른쪽.
    * 현재 인터벌의 시작이 새 인터벌의 끝보다 크면 병합할 수 없다.
3. 병합할 수 있는 구간.
    * 왼쪽, 오른쪽에 해당되지 않는 구간의 인터벌은 새 인터벌과 겹친다고 판단할 수 있으니 병합 할 수 있다.

## Algorithm
1. ```n```, ```idx``` 를 선언하여 인터벌의 길이와 현재 인덱스를 저장한다.
2. 왼쪽 구간의 끝 구하기 위해 현재 인터벌의 끝이 새 인터벌의 시작보다 작으면 ```idx``` 를 증가시킨다.
3. ```left``` 에 병합 가능 구간의 시작인 현재 ```idx``` 를 저장한다.
4. 오른쪽 구간의 시작을 구하기 위해 현재 인터벌의 시작이 새 인터벌의 끝보다 작거나 같으면 ```idx``` 를 증가시키면서, 현재는 병합 가능 구간이기 때문에 새 인터벌을 업데이트한다.
5. ```right``` 에 오른쪽 구간의 시작인 현재 ```idx``` 를 저장한다.
6. ```res``` 에 왼쪽 구간, 새 인터벌, 오른쪽 구간을 저장하고 리턴한다.

## Implementation
```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int idx = 0;

        while (idx < n && intervals[idx][1] < newInterval[0]) {
            idx++;
        }

        int left = idx;
        
        while (idx < n && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }

        int right = idx;

        int[][] res = new int[left + 1 + (n - right)][];

        idx = 0;
        while (idx < left) {
            res[idx] = intervals[idx];
            idx++;
        }

        res[idx++] = newInterval;

        while (right < n) {
            res[idx++] = intervals[right++];
        }

        return res;
    }
}
```

## Complexity
- Time complexity: O(n)    
병합을 위한 순회와 결과 저장을 위한 순회로 시간복잡도는 O(n).

- Space complexity: O(1)   
결과를 저장하기 위한 배열을 제외하고 사용한 공간은 O(1).
