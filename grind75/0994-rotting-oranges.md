# [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)

## Intuition
BFS 기법을 이용해 썩은 오렌지로부터 영역을 넓혀 최소 시간을 구할 수 있다. 

## Algorithm
1. `grid`를 탐색하여 썩은 오렌지의 위치는 `queue`에 삽입, 신선한 오렌지의 개수를 `freshOrange`에 저장.
2. 썩은 오렌지와 신선한 오렌지가 남아있다면 아래를 반복
   1. 영역을 한번에 넓히기 위해 `queue`에 있는 썩은 오렌지 개수를 `size`에 저장.
   2. `size`만큼 썩은 오렌지를 꺼내고 인접한 셀에 신선한 오렌지가 있다면 썩은 오렌지로 바꾸고 `queue`에 위치를 삽입.
   3. 영역을 넓혔으니 `res`를 1 증가시킨다.
3. 신선한 오렌지가 없다면 `res`를 리턴, 남아있다면 -1을 리턴.

## Implementation
```java
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        int freshOrange = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty() && freshOrange > 0) {
            int size = queue.size();

            while (size-- > 0) {
                int[] curr = queue.poll();

                for (int[] d : dir) {
                    int nextR = curr[0] + d[0];
                    int nextC = curr[1] + d[1];

                    if (nextR < 0 || nextR == m || nextC < 0 || nextC == n || grid[nextR][nextC] != 1) {
                        continue;
                    }

                    grid[nextR][nextC] = 2;
                    freshOrange--;
                    queue.offer(new int[] {nextR, nextC});
                }
            }

            res++;
        }

        return freshOrange == 0 ? res : -1;
    }
}
```

## Complexity
`m`, `n`은 `grid`의 행과 열.
- Time complexity: O(m * n)\
`grid`탐색과 BFS로 사용한 시간. 

- Space complexity: O(m * n)\
`queue`에서 사용한 공간. 