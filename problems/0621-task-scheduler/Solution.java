class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        char[] count = new char[26];
        int numOfTask = 0;
        
        for (char c : tasks) {
            if (count[c - 'A'] == 0) {
                numOfTask++;
            }
            count[c - 'A']++;
        }

        if (n >= numOfTask) {
            int maxCount = 0;
            int numOfMaxCount = 0;

            for (int c : count) {
                if (c > maxCount) {
                    maxCount = c;
                    numOfMaxCount = 1;
                } else if (c == maxCount) {
                    numOfMaxCount++;
                }
            }

            return (n + 1) * (maxCount - 1) + numOfMaxCount;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : count) {
            if (c > 0) {
                pq.offer(c);
            }
        }

        int res = 0;

        while (!pq.isEmpty()) {
            int last = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; !pq.isEmpty() && i <= n; i++) {
                int next = pq.poll() - 1;
                if (next > 0) {
                    list.add(next);
                } else {
                    last++;
                }
            }

            if (list.isEmpty()) {
                res += last;
            } else {
                res += n + 1;
                pq.addAll(list);
            }
        }

        return res;
    }
}
