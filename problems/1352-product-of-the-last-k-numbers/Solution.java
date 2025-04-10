class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();    
        prefix.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1);
            return;
        }

        prefix.add(num * prefix.get(prefix.size() - 1));
    }
    
    public int getProduct(int k) {
        int lastIndex = prefix.size() - 1;
        
        if (k > lastIndex) {
            return 0;
        }

        return prefix.get(lastIndex) / prefix.get(lastIndex - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
