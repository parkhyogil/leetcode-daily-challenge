class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<>()).add(ticket.get(1));
        }

        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", graph, res);
        return res;   
    }

    private void dfs(String from, Map<String, PriorityQueue<String>> graph, LinkedList<String> res) {
        PriorityQueue<String> pq = graph.get(from);

        while (pq != null && !pq.isEmpty()) {
            String to = pq.poll();
            dfs(to, graph, res);
        }
        res.addFirst(from);
    }
}
