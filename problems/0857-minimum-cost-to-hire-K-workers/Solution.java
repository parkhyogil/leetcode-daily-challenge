class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        List<Pair<Double, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair<>((double) wage[i] / quality[i], quality[i]));
        }

        Collections.sort(list, (a, b) -> Double.compare(a.getKey(), b.getKey()));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        double res = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int q = list.get(i).getValue();

            pq.offer(q);
            count += q;

            if (pq.size() > k) {
                count -= pq.poll();
            }

            if (pq.size() == k) {
                res = Math.min(res, count * list.get(i).getKey());
            }
        }

        return res;
    }
}
