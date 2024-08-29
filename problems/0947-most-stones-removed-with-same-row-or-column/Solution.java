class Solution {
    class DisjointSet {
        private int size;
        private int[] parent;

        public DisjointSet(int size) {
            this.size = size;
            parent = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);

            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }

        public int find(int child) {
            if (child == parent[child]) {
                return child;
            }
            return parent[child] = find(parent[child]);
        }

        public int countSets() {
            int num = 0;

            for (int i = 0; i < size; i++) {
                if (i == find(i)) {
                    num++;
                }
            }

            return num;
        }
    }
    
    public int removeStones(int[][] stones) {
        int n = stones.length;

        DisjointSet ds = new DisjointSet(n);

        int[] rowRepresentative = new int[10001];
        Arrays.fill(rowRepresentative, -1);

        int[] colRepresentative = new int[10001];
        Arrays.fill(colRepresentative, -1);

        for (int i = 0; i < n; i++) {
            int row = stones[i][0];
            int col = stones[i][1];

            if (rowRepresentative[row] == -1) {
                rowRepresentative[row] = i;
            } else {
                ds.union(i, rowRepresentative[row]);
            }

            if (colRepresentative[col] == -1) {
                colRepresentative[col] = i;
            } else {
                ds.union(i, colRepresentative[col]);
            }
        }

        return n - ds.countSets();
    }
}
