# [207. Course Schedule](https://leetcode.com/problems/course-schedule/description/)

## Intuition
코스의 연관관계에 사이클이 없다면 코스를 완료할 수 있다. 

## Algorithm
1. `prerequisites`를 간선으로 하는 그래프를 만든다.
2. 그래프에 사이클이 있는지 모든 노드를 확인한다.
   1. 확인한 노드라면 사이클 여부를 리턴.
   2. DFS 기법으로 그래프를 순회하며 거쳐간 노드들을 `hasCycle`에 표시한다.
   3. 방문한 노드가 `hasCycle`에 있다면 사이클이 존재한다.
   4. 사이클이 없다면 재귀함수를 빠져나오면서 `hasCycle`에서 삭제한다.

## Implementation
```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] hasCycle = new boolean[numCourses];
        boolean[] visit = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (checkCycle(i, graph, hasCycle, visit)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCycle(int course, List<List<Integer>> graph, boolean[] hasCycle, boolean[] visit) {
        if (visit[course]) {
            return hasCycle[course];
        }

        visit[course] = true;
        hasCycle[course] = true;

        for (int next : graph.get(course)) {
            if (checkCycle(next, graph, hasCycle, visit)) {
                return true;
            }
        }

        return hasCycle[course] = false;
    }
}
```

## Complexity
`n`은 노드의 개수, `m`은 간선의 개수
- Time complexity: O(n + m)\
그래프를 순회하면서 사용한 시간.

- Space complexity: O(n + m)\
그래프에서 사용한 공간.
