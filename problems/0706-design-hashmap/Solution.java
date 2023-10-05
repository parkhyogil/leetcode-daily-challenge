class MyHashMap {
    private int capacity = 10000;
    private Node[] arr;

    public MyHashMap() {
        arr = new Node[capacity];
    }
    
    public void put(int key, int value) {
        int idx = getIdx(key);

        Node node = arr[idx];
        while (node != null && node.key != key) {
            node = node.next;
        }

        if (node == null) {
            arr[idx] = new Node(key, value, arr[idx]);
        } else {
            node.val = value;
        }
    }
    
    public int get(int key) {
        int idx = getIdx(key);
        
        Node node = arr[idx];
        while (node != null && node.key != key) {
            node = node.next;
        }

        return node == null ? -1 : node.val;
    }
    
    public void remove(int key) {
        int idx = getIdx(key);

        Node node = arr[idx];
        Node prev = null;

        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }

        if (node != null) {
            if (prev == null) {
                arr[idx] = node.next;
            } else {
                prev.next = node.next;
            }
        }
    }

    private int getIdx(int key) {
        return key % capacity;
    }

    private class Node {
        private int key, val;
        private Node next;

        private Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
