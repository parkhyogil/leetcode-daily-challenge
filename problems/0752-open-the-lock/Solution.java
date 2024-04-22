class Solution {
    public int openLock(String[] deadends, String target) {
        int t = Integer.parseInt(target);

        boolean[] visit = new boolean[10000];
        for (String s : deadends) {
            visit[Integer.parseInt(s)] = true;
        }

        if (visit[0]) {
            return -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visit[0] = true;

        int res = 0;
        while (!queue.isEmpty() && !visit[t]) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();

                for (int i = 1; i <= 1000; i *= 10) {
                    int num = curr / i % 10;
                    int others = curr - num * i;

                    int up = num == 9 ? others : others + (num + 1) * i;
                    if (!visit[up]) {
                        visit[up] = true;
                        queue.offer(up);
                    }

                    int down = num == 0 ? others + 9 * i : others + (num - 1) * i;
                    if (!visit[down]) {
                        visit[down] = true;
                        queue.offer(down);
                    }
                }
            }
            res++;
        }

        return visit[t] ? res : -1;
    }
}