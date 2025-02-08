class NumberContainers {
    Map<Integer, Integer> indexNumberMap;
    Map<Integer, PriorityQueue<Integer>> numberIndexHeapMap;

    public NumberContainers() {
        indexNumberMap = new HashMap<>();
        numberIndexHeapMap = new HashMap<>();    
    }
    
    public void change(int index, int number) {
        indexNumberMap.put(index, number);
        numberIndexHeapMap.computeIfAbsent(number, k -> new PriorityQueue<>()).add(index);
    }
    
    public int find(int number) {
        if (!numberIndexHeapMap.containsKey(number)) {
            return -1;
        }

        PriorityQueue<Integer> pq = numberIndexHeapMap.get(number);
        while (!pq.isEmpty() && number != indexNumberMap.get(pq.peek())) {
            pq.poll();
        }

        return pq.isEmpty() ? -1 : pq.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
