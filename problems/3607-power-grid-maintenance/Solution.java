class Solution {
    int n;
    int[] root;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        n = c + 1;
        root = new int[n];
        
        for (int i = 1; i < n; i++) {
            root[i] = i;
        }

        for (int[] con : connections) {
            union(con[0], con[1]);
        }

        Map<Integer, PriorityQueue<Integer>> queueMap = new HashMap<>();

        for (int i = 1; i < n; i++) {
            if (findRoot(i) == i) {
                queueMap.put(i, new PriorityQueue<>());
            }
            queueMap.get(findRoot(i)).offer(i);
        }

        List<Integer> list = new ArrayList<>();
        boolean[] isOffline = new boolean[n];

        for (int[] q : queries) {
            if (q[0] == 1) {
                if (isOffline[q[1]]) {
                    PriorityQueue<Integer> queue = queueMap.get(findRoot(q[1]));
                    while (!queue.isEmpty() && isOffline[queue.peek()]) {
                        queue.poll();
                    }

                    list.add(queue.isEmpty() ? -1 : queue.peek());
                } else {
                    list.add(q[1]);
                }
            } else {
                isOffline[q[1]] = true;
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a < b) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }

    int findRoot(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = findRoot(root[x]);
    }
}
