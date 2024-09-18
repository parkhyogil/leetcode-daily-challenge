# [815. Bus Routes](https://leetcode.com/problems/bus-routes/description/)

## Intuition
정류장과 버스 노선의 관계를 그래프로 생각하여 **BFS** 기법을 사용해 최소 버스 탑승 횟수를 구할 수 있다.

정류장은 노드가 되고, 노선은 노드를 잇는 엣지가 된다. 같은 노선에 있는 정류장들은 한 번에 이동할 수 있다.

예를 들어, 아래와 같은 입력이 주어졌을 때
```
routes = [[1,2,7],[3,6,7]], source = 1, target = 6
```
먼저, 각 정류장을 통과하는 노선을 정리한다.
```
busStop     routeIndex
1           0
2           0
3           1
6           1
7           0,1
```
그 다음, 출발 정류장에서 BFS를 시작한다.
```
queue = {1}
```
큐에서 `1`번 정류장을 꺼내고, 이 정류장을 지나는 노선을 확인한다. `0`번 노선을 통해 아직 방문하지 않은 정류장들을 큐에 추가한다.
```
queue = {2,7}
```
그 다음 `2`번 정류장을 꺼내고, 이미 확인된 `0`번 노선이므로 넘어간다. `7`번 정류장을 꺼내고, `1`번 노선으로 이동할 수 있는 정류장들을 큐에 추가한다.
```
queue = {3,6}
```
이후 `3`번 정류장을 꺼내고, 이미 확인된 `1`번 노선이므로 넘어간다. `6`번 정류장을 꺼냈을 때, 목표 정류장에 도착했다.

위와 같이 BFS 기법으로 모든 정류장과 모든 노선을 한 번씩 확인하여 최소 버스 탑승 횟수를 구할 수 있다.




## Implementation
```java
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length;

        Map<Integer, List<Integer>> stopToRouteMap = new HashMap<>();
        int maxBusStop = 0;

        for (int i = 0; i < n; i++) {
            for (int busStop : routes[i]) {
                stopToRouteMap.computeIfAbsent(busStop, k -> new ArrayList<>()).add(i);
                maxBusStop = Math.max(maxBusStop, busStop);
            }
        }

        if (!stopToRouteMap.containsKey(source) || !stopToRouteMap.containsKey(target)) {
            return -1;
        }

        Queue<Integer> stopQueue = new ArrayDeque<>();

        boolean[] visitedStops = new boolean[maxBusStop + 1];
        boolean[] visitedRoutes = new boolean[n];

        stopQueue.offer(source);
        visitedStops[source] = true;

        int result = 0;

        while (!stopQueue.isEmpty()) {
            int size = stopQueue.size();

            for (int i = 0; i < size; i++) {
                int busStop = stopQueue.poll();

                if (busStop == target) {
                    return result;
                }

                for (int route : stopToRouteMap.get(busStop)) {
                    if (visitedRoutes[route]) {
                        continue;
                    }

                    visitedRoutes[route] = true;

                    for (int nextBusStop : routes[route]) {
                        if (visitedStops[nextBusStop]) {
                            continue;
                        }

                        stopQueue.offer(nextBusStop);
                        visitedStops[nextBusStop] = true;
                    }
                }
            }
            result++;
        }

        return -1;
    }
}
```

## Complexity
`n`은 `routes`의 길이, `m`은 `busStop`의 수.
- Time complexity: O(n * m)
- Space complexity: O(n * m)
