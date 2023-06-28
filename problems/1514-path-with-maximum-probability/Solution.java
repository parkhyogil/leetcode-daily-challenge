class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(b.w, a.w));
        double[] prob = new double[n];

        pq.offer(new Edge(start, 1));
        prob[start] = 1;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.v;
            double w = curr.w;

            if (prob[u] > w) {
                continue;
            }

            for (Edge e : graph.get(u)) {
                int v = e.v;
                double vw = w * e.w;
                if (vw > prob[v]) {
                    prob[v] = vw;
                    pq.offer(new Edge(v, vw));
                }
            }
        }
        return prob[end];
    }

    class Edge {
        public int v;
        public double w;

        public Edge(int v, double w) {
            this.v = v;
            this.w = w;
        }
    }
}
