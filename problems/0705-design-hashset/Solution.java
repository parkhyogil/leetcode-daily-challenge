class MyHashSet {
    private final int loadFactor = 10000;
    private Node[] arr;

    public MyHashSet() {
        arr = new Node[loadFactor];
    }
    
    public void add(int key) {
        if (contains(key)) {
            return;
        }
        int idx = getIdx(key);
        Node newNode = new Node(key);

        newNode.next = arr[idx];
        if (arr[idx] != null) {
            arr[idx].prev = newNode;
        }
        arr[idx] = newNode;
    }
    
    public void remove(int key) {
        Node node = getNode(key);
        if (node == null) {
            return;
        }

        if (node.prev == null) {
            arr[getIdx(key)] = node.next;
        } else if (node.next == null) {
            node.prev.next = null;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        node.next = null;
        node.prev = null;
    }
    
    public boolean contains(int key) {
        return getNode(key) != null;
    }

    private int getIdx(int key) {
        return key % loadFactor;
    }

    private Node getNode(int key) {
        Node node = arr[getIdx(key)];
        while (node != null && node.val != key) {
            node = node.next;
        }
        return node;
    }

    class Node {
        int val;
        Node prev, next;

        private Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
