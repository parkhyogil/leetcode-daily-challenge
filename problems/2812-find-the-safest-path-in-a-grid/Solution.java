class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int[][] dir = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[n][n];

        for (int[] d : dist) {
            Arrays.fill(d, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new int[] {i, j});            
                    dist[i][j] = 0;
                }
            }
        }

        List<List<int[]>> groupByDist = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            groupByDist.add(new ArrayList<>());

            while (size-- > 0) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                groupByDist.get(dist[r][c]).add(cur);

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr == n || nc < 0 || nc == n || dist[nr][nc] != -1) {
                        continue;
                    }

                    queue.offer(new int[] {nr, nc});
                    dist[nr][nc] = dist[r][c] + 1;
                }
            }
        }

        int maxDist = groupByDist.size() - 1;
        DisjointSet ds = new DisjointSet(n * n);

        for (int i = maxDist; i >= 0; i--) {
            for (int[] pos : groupByDist.get(i)) {
                int r = pos[0];
                int c = pos[1];

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr == n || nc < 0 || nc == n || dist[nr][nc] < dist[r][c]) {
                        continue;
                    }

                    ds.union(r * n + c, nr * n + nc);
                }
            }

            if (ds.findRoot(0) == ds.findRoot(n * n - 1)) {
                return i;
            }
        }   

        return -1;
    }

    class DisjointSet {
        private int size;
        private int[] root;

        public DisjointSet(int size) {
            this.size = size;
            root = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public void union(int a, int b) {
            a = findRoot(a);
            b = findRoot(b);

            if (a < b) {
                root[b] = a;
            } else {
                root[a] = b;
            }
        }

        public int findRoot(int child) {
            if (child == root[child]) {
                return child;
            }
            return root[child] = findRoot(root[child]);
        }
    }
}
