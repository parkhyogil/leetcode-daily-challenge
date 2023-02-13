class LFUCache {
    private int capacity;
    private int minFrequency;
    private Map<Integer, Integer> valueOf;
    private Map<Integer, Integer> frequencyOf;
    private Map<Integer, LinkedHashSet<Integer>> keysByFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFrequency = 0;
        valueOf = new HashMap<>();
        frequencyOf = new HashMap<>();
        keysByFrequency = new HashMap<>();
    }

    public int get(int key) {
        if (!valueOf.containsKey(key)) {
            return -1;
        }
        int val = valueOf.get(key);
        int freq = frequencyOf.get(key);

        Set<Integer> keys = keysByFrequency.get(freq);
        keys.remove(key);
        if (minFrequency == freq && keys.isEmpty()) {
            minFrequency++;
        }
        insert(key, freq + 1, val);
        return val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (valueOf.containsKey(key)) {
            valueOf.put(key, value);
            get(key);
            return;
        }
        if (valueOf.size() == capacity) {
            Set<Integer> keys = keysByFrequency.get(minFrequency);
            int keyToDelete = keys.iterator().next();
            valueOf.remove(keyToDelete);
            frequencyOf.remove(keyToDelete);
            keys.remove(keyToDelete);
        }
        minFrequency = 1;
        insert(key, 1, value);
    }

    private void insert(int key, int freq, int val) {
        valueOf.put(key, val);
        frequencyOf.put(key, freq);
        keysByFrequency.putIfAbsent(freq, new LinkedHashSet<>());
        keysByFrequency.get(freq).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
