# [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/description/)

## Intuition
max heap을 이용해 k 개의 작은 값을 얻을 수 있다.

## Algorithm
1. priority queue `pq`를 선언하고 큰 값을 우선순위로 설정.
2. `points` 배열을 순회하면서 `pq`에 삽입하고 사이즈가 `k`를 초과할 경우 최대값을 삭제.
3. `pq`에 남아있는 값을 결과로 리턴.

## Implementation
```java
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> getDistance(b) - getDistance(a));

        for (int[] p : points) {
            pq.offer(p);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }

    private int getDistance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
```

## Complexity
- Time complexity: O(nlogk)    
배열을 순회하면서 `k` 사이즈의 맥스힙에 `n`번의 삽입,삭제 연산이 발생.

- Space complexity: O(k)   
`pq`에서 `k`개의 값이 필요.
