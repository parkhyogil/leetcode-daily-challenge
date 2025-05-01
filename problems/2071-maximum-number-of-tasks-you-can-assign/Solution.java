class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length;
        int m = workers.length;

        Arrays.sort(tasks);
        Arrays.sort(workers);

        int lo = 0;
        int hi = Math.min(n, m);

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (isPossible(mid, tasks, workers, pills, strength)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }

    private boolean isPossible(int numTasks, int[] tasks, int[] workers, int pills, int strength) {
        int j = workers.length - 1;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = numTasks - 1; i >= 0; i--) {
            while (j >= 0 && tasks[i] <= workers[j] + strength) {
                deque.addFirst(workers[j--]);
            }

            if (deque.isEmpty()) {
                return false;
            }

            if (deque.getLast() >= tasks[i]) {
                deque.removeLast();
            } else {
                if (pills == 0) {
                    return false;
                }
                deque.removeFirst();
                pills--;
            }
        }
        
        return true;
    }
}
