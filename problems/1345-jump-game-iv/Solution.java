class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int i = queue.poll();

                if (i == n - 1) {
                    return result;
                }

                if (i > 0 && !visited[i - 1]) {
                    queue.offer(i - 1);
                    visited[i - 1] = true;
                }

                if (i + 1 < n && !visited[i + 1]) {
                    queue.offer(i + 1);
                    visited[i + 1] = true;
                }

                if (map.containsKey(arr[i])) {
                    for (int j : map.get(arr[i])) {
                        if (!visited[j]) {
                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                    map.remove(arr[i]);
                }
            }
            result++;
        }

        return -1;
    }
}
