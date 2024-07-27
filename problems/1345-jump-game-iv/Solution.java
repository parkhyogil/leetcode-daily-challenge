class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n];

        q.offer(0);
        visit[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int curr = q.poll();
                if (curr == n - 1) {
                    return res;
                }

                if (map.containsKey(arr[curr])) {
                    for (int next : map.get(arr[curr])) {
                        if (visit[next]) {
                            continue;
                        }
                        q.offer(next);
                        visit[next] = true;
                    }
                }
                map.remove(arr[curr]);

                if (curr - 1 >= 0 && !visit[curr - 1]) {
                    q.offer(curr - 1);
                    visit[curr - 1] = true;
                }
                if (curr + 1 < n && !visit[curr + 1]) {
                    q.offer(curr + 1);
                    visit[curr + 1] = true;
                }
            }
            res++;
        }
        return -1;
    }
}
