# [295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/description/)

## Intuition
정렬된 리스트를 반으로 나누어, 왼쪽 리스트는 `MaxHeap`으로 관리해 가장 큰 값을 빠르게 찾고, 오른쪽 리스트는 `MinHeap`으로 관리해 가장 작은 값을 빠르게 찾는다.\
값을 삽입할 때, 두 리스트의 크기를 균형 있게 유지하며, 왼쪽 리스트의 가장 큰 값이 오른쪽 리스트의 가장 작은 값보다 클 경우, 두 값을 교환한다.

## Algorithm
- `addNum` 메소드 
  - 두 리스트의 사이즈가 같을 경우 `leftList`에 `num`을 삽입한다. 그렇지 않다면 `rightList`에 삽입한다.
  - `leftList`에서 가장 큰 값이 `rightList`에서 가장 작은 값보다 클 경우 두 값을 교환하여 스트림을 정렬된 상태로 유지한다.
- `findMedian` 메소드
  - `leftList`의 사이즈가 `rightList`의 사이즈보다 크다면 `leftList`에서 가장 큰 값을 반환한다.
  - 두 리스트의 사이즈가 같을 경우 `leftList`에서 가장 큰 값과 `rightList`에서 가장 작은 값의 사이값을 반환한다.

## Implementation
```java
class MedianFinder {
    private PriorityQueue<Integer> leftList, rightList;

    public MedianFinder() {
        leftList = new PriorityQueue<>(Collections.reverseOrder());
        rightList = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (leftList.size() == rightList.size()) {
            leftList.offer(num);
        } else {
            rightList.offer(num);
        }

        if (!rightList.isEmpty() && leftList.peek() > rightList.peek()) {
            int tmp = leftList.poll();
            leftList.offer(rightList.poll());
            rightList.offer(tmp);
        }
    }
    
    public double findMedian() {
        if (leftList.size() > rightList.size()) {
            return leftList.peek();
        }
        
        return (leftList.peek() + rightList.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
```

## Complexity
`n`은 삽입된 `num`의 개수
- Time complexity:
  - `addNum` : O(logn)
  - `findMedian` : O(1)
- Space complexity: O(n)
