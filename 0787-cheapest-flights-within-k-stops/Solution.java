class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(flight);
        }

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});

        while (k-- >= 0 && !q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int from = cur[0];
                int curPrice = cur[1];

                for (int[] f : graph.get(from)) {
                    int to = f[1];
                    int price = f[2];

                    int totalPrice = curPrice + price;
                    if (totalPrice < prices[to]) {
                        prices[to] = totalPrice;
                        q.offer(new int[] {to, totalPrice});
                    }
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
