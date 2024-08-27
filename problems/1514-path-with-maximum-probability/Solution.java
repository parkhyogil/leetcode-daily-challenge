class Solution {
    class Edge implements Comparable<Edge> {
        public int node;
        public double probability;

        public Edge(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }

        @Override
        public int compareTo(Edge e) {
            return Double.compare(e.probability, this.probability);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Edge>> graph = buildGraph(n, edges, succProb);

        return runDijkstra(n, start_node, end_node, graph);
    }

    private double runDijkstra(int n, int source, int destination, List<List<Edge>> graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        double[] probabilities = new double[n];

        priorityQueue.offer(new Edge(source, 1));
        probabilities[source] = 1;

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            
            int node = edge.node;
            double probability = edge.probability;

            if (probability < probabilities[node]) {
                continue;
            }

            for (Edge nextEdge : graph.get(node)) {
                int nextNode = nextEdge.node;
                double nextProbability = nextEdge.probability * probability;

                if (nextProbability > probabilities[nextNode]) {
                    priorityQueue.offer(new Edge(nextNode, nextProbability));
                    probabilities[nextNode] = nextProbability;
                }
            }
        }

        return probabilities[destination];
    }

    private List<List<Edge>> buildGraph(int n, int[][] edges, double[] succProb) {
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

        return graph;
    }
}
