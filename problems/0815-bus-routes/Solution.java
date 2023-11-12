class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int busStop : routes[i]) {
                map.computeIfAbsent(busStop, key -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[routes.length];
        Set<Integer> busVisit = new HashSet<>();

        q.offer(source);
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int busStop = q.poll();

                if (busStop == target) {
                    return res;
                }

                for (int route : map.get(busStop)) {
                    if (visit[route]) {
                        continue;
                    }
                    for (int next : routes[route]) {
                        if (!busVisit.contains(next)) {
                            q.offer(next);
                            busVisit.add(next);
                        }
                    }
                    visit[route] = true;
                }
            }
            res++;
        }

        return -1;
    }
}
