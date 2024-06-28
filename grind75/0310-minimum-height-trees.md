# [310. Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/description/)

## Intuition
트리의 높이를 최소가 되도록 하는 루트 노드는 트리의 지름에서 가운데 있는 노드일 것이고 트리의 지름을 구성하는 노드들의 개수가 짝수일 경우 둘, 홀수일 경우 하나가 된다.\
BFS 기법을 사용해 노드가 두 개 이하로 남을 때까지 리프 노드를 순차적으로 제거해서 루트 노드를 찾는다.

## Algorithm
1. 주어진 배열 `edges`로 그래프 `graph`를 만든다.
2. 배열 `degree`에 각 노드가 갖는 degree 개수를 저장한다.
3. 리프 노드를 저장할 큐 `queue`를 초기화한다.
4. 노드의 degree가 1이라면 리프 노드이다. `degree`를 순회해 리프 노드를 `queue`에 삽입한다.
5. `remainingNodes`에 현재 남아있는 노드 개수를 저장한다.
6. 트리에 노드가 두 개 이하로 남을 때까지 아래를 반복한다.
   1. `leafNodes`에 `queue`의 사이즈를 저장한다. 현재 트리의 리프 노드 개수가 된다.
   2. `remainingNodes`에서 `leafNodes`를 뺀다.
   3. 리프 노드와 부모 노드의 degree를 1 감소시킨다. 부모 노드의 degree가 1이라면 리프 노드가 됐으니 `queue`에 삽입한다.
7. `queue`에 있는 노드를 리스트에 담아 리턴한다.

## Implementation
```java
class Solution {
   public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      if (n == 1) {
         return List.of(0);
      }

      List<List<Integer>> graph = makeGraph(n, edges);
      int[] degree = countDegree(n, edges);

      Queue<Integer> queue = new LinkedList<>();

      for (int i = 0; i < n; i++) {
         if (degree[i] == 1) {
            queue.offer(i);
         }
      }

      int remainingNodes = n;

      while (remainingNodes > 2) {
         int leafNodes = queue.size();
         remainingNodes -= leafNodes;

         while (leafNodes-- > 0) {
            int node = queue.poll();
            degree[node] = 0;

            int parentNode = getParentNode(node, graph, degree);
            degree[parentNode]--;

            if (degree[parentNode] == 1) {
               queue.offer(parentNode);
            }
         }
      }

      return new ArrayList<>(queue);
   }

   private int getParentNode(int node, List<List<Integer>> graph, int[] degree) {
      for(int adjacent : graph.get(node)) {
         if (degree[adjacent] > 0) {
            return adjacent;
         }
      }

      return -1;
   }

   private int[] countDegree(int n, int[][] edges) {
      int[] res = new int[n];

      for (int[] edge : edges) {
         res[edge[0]]++;
         res[edge[1]]++;
      }

      return res;
   }

   private List<List<Integer>> makeGraph(int n, int[][] edges) {
      List<List<Integer>> res = new ArrayList<>();

      for (int i = 0; i < n; i++) {
         res.add(new ArrayList<>());
      }

      for (int[] edge : edges) {
         int u = edge[0];
         int v = edge[1];

         res.get(u).add(v);
         res.get(v).add(u);
      }

      return res;
   }
}
```

## Complexity
`n`은 노드의 개수
- Time complexity: O(n)\
BFS의 시간 복잡도는 노드의 개수 + 간선의 개수이다. 주어진 간선의 개수는 `n - 1`개로 최종 시간 복잡도는 O(n)이 된다.

- Space complexity: O(n)\
`graph`, `queue`, `degree`에서 사용한 공간.
