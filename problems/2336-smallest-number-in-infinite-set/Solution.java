class SmallestInfiniteSet {
    private PriorityQueue<Integer> pq;
    private Set<Integer> set;
    private int curr;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        curr = 1;
    }
    
    public int popSmallest() {
        if (pq.isEmpty()) {
            return curr++;
        }
        int res = pq.poll();
        set.remove(res);
        return res;
    }
    
    public void addBack(int num) {
        if (num < curr && !set.contains(num)) {
            pq.offer(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
