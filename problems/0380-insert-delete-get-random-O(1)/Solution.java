class RandomizedSet {
    private List<Integer> values;
    private Map<Integer, Integer> indexOf;

    public RandomizedSet() {
        values = new ArrayList<>();
        indexOf = new HashMap<>();    
    }
    
    public boolean insert(int val) {
        if (indexOf.containsKey(val)) {
            return false;
        }

        indexOf.put(val, values.size());
        values.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if (!indexOf.containsKey(val)) {
            return false;
        }

        int index = indexOf.get(val);
        int lastVal = values.get(values.size() - 1);

        indexOf.put(lastVal, index);
        values.set(index, lastVal);

        indexOf.remove(val);
        values.remove(values.size() - 1);

        return true;
    }
    
    public int getRandom() {
        return values.get((int) (Math.random() * values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
