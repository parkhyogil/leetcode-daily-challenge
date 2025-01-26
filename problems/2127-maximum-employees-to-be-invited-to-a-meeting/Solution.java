class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        boolean[] hasCycle = new boolean[n];
        int[] lineLength = new int[n];

        doTopologicalSort(n, favorite, hasCycle, lineLength);

        boolean[] checked = new boolean[n];
        int straightLineLength = 0;
        int maxCycleLength = 0;

        for (int i = 0; i < n; i++) {
            if (hasCycle[i] && !checked[i]) {
                int cycleLength = getCycleLength(favorite, checked, i);

                if (cycleLength == 2) {
                    straightLineLength += lineLength[i] + lineLength[favorite[i]];
                }

                maxCycleLength = Math.max(maxCycleLength, cycleLength);
            }
        }

        return Math.max(maxCycleLength, straightLineLength);
    }

    private int getCycleLength(int[] edge, boolean[] checked, int node) {
        checked[node] = true;
        int next = edge[node];
        int length = 1;

        while (next != node) {
            checked[next] = true;
            next = edge[next];
            length++;
        }

        return length;
    }

    private void doTopologicalSort(int n, int[] edge, boolean[] hasCycle, int[] lineLength) {
        int[] indegree = new int[n];
        for (int next : edge) {
            indegree[next]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            hasCycle[i] = true;
            lineLength[i] = 1;

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int next = edge[node];

            hasCycle[node] = false;

            lineLength[next] = lineLength[node] + 1;
            indegree[next]--;

            if (indegree[next] == 0) {
                queue.offer(next);
            }
        }
    }
}
