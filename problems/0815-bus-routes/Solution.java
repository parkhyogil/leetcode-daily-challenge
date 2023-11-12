class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        for (int[] route : routes) {
            Arrays.sort(route);
        }
        
        int n = routes.length;
        
        boolean[][] graph = new boolean[n][n];
        boolean[] visit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> targetRoute = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                if (stop == source) {
                    queue.offer(i);
                    visit[i] = true;
                }

                if (stop == target) {
                    targetRoute.add(i);
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (isConnected(routes[i], routes[j])) {
                    graph[i][j] = graph[j][i] = true;
                }
            }
        }

        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int route = queue.poll();

                if (targetRoute.contains(route)) {
                    return res;
                }

                for (int next = 0; next < n; next++) {
                    if (graph[route][next] && !visit[next]) {
                        queue.offer(next);
                        visit[next] = true;
                    }
                }
            }
            res++;
        }

        return -1;
    }

    private boolean isConnected(int[] a, int[] b) {
        int i = 0; 
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                return true;
            }

            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
}
