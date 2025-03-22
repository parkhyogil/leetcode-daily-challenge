class Solution {
    private int[] root, componentSize, edgeCount;

    public int countCompleteComponents(int n, int[][] edges) {
        root = new int[n];
        componentSize = new int[n];
        edgeCount = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            componentSize[i] = 1;
        }

        for (int[] edge : edges) {
            int a = findRoot(edge[0]);
            int b = findRoot(edge[1]);

            if (a == b) {
                edgeCount[a]++;
            } else if (a < b) {
                root[b] = a;
                componentSize[a] += componentSize[b];
                edgeCount[a] += edgeCount[b] + 1;
            } else {
                root[a] = b;
                componentSize[b] += componentSize[a];
                edgeCount[b] += edgeCount[a] + 1;
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (isCompleteComponent(i)) {
                result++;
            }
        }

        return result;
    }

    private int findRoot(int child) {
        if (child == root[child]) {
            return child;
        }
        return root[child] = findRoot(root[child]);
    }

    private boolean isCompleteComponent(int node) {
        return node == findRoot(node) && edgeCount[node] == componentSize[node] * (componentSize[node] - 1) / 2;
    }
}
