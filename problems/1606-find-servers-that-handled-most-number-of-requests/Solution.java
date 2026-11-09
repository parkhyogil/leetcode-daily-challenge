class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;

        int[] f = new int[k];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            set.add(i);
        }

        for (int i = 0; i < n; i++) {
            int a = arrival[i];
            int l = load[i];

            while (!pq.isEmpty() && pq.peek()[1] <= a) {
                int[] j = pq.poll();
                set.add(j[0]);
            }

            if (set.isEmpty()) {
                continue;
            }            

            Integer s = set.ceiling(i % k);

            if (s == null) {
                s = set.first();
            }

            pq.offer(new int[] {s, a + l});
            f[s]++;

            set.remove(s);
        }

        int max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, f[i]);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (f[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
