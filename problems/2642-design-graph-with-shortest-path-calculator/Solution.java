class Graph {
    private final int INF = (int) 1e9;
    
    private int n;
    private int[][] dist;

    public Graph(int n, int[][] edges) {
        this.n = n;
        dist = new int[n][n];

        for (int[] d : dist) {
            Arrays.fill(d, INF);
        }

        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        for (int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Math.min(dist[i][j], dist[i][edge[0]] + dist[edge[1]][j] + edge[2]);
            }
        }
    }
    public int shortestPath(int node1, int node2) {
        return dist[node1][node2] == INF ? -1 : dist[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
