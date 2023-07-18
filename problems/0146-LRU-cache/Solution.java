class LinkedMap {
    private int size, capacity;
    private Node head, tail;
    private Node[] map;

    public LinkedMap(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new Node[10001];

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public boolean containsKey(int key) {
        return map[key] != null;
    }

    public void put(int key, int value) {
        if (containsKey(key)) {
            map[key].val = value;
            return;
        }
        if (size == capacity) {
            remove(head.next.key);
        }

        Node newNode = new Node(key, value);
        map[key] = newNode;

        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        tail.prev = newNode;
        newNode.next = tail;

        size++;
    }

    public void remove(int key) {
        Node node = map[key];
        map[key] = null;
        
        Node prev = node.prev;
        Node next = node.next;

        node.prev = null;
        node.next = null;

        prev.next = next;
        next.prev = prev;
        size--;
    }

    public int get(int key) {
        return containsKey(key) ? map[key].val : -1;
    }

    private class Node {
        int key, val;
        Node prev, next;

        private Node() {}
        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

class LRUCache {
    private int capacity, size;
    private LinkedMap map;


    public LRUCache(int capacity) {
        map = new LinkedMap(capacity);
    }

    public int get(int key) {
        int value = map.get(key);
        if (value != -1) {
            put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);
    }
}
