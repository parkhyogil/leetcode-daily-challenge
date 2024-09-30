class AllOne {
    LinkedList<Integer> frequencyList;
    Map<Integer, Node<Integer>> freqToFreqNodeMap;
    Map<Integer, LinkedList<String>> freqToKeyListMap;
    Map<String, Integer> keyToFreqMap;
    Map<String, Node<String>> keyToKeyNodeMap;

    public AllOne() {
        frequencyList = new LinkedList<>();
        freqToKeyListMap = new HashMap<>();
        keyToFreqMap = new HashMap<>();
        freqToFreqNodeMap = new HashMap<>();
        keyToKeyNodeMap = new HashMap<>();
    }

    public void inc(String key) {
        if (!keyToFreqMap.containsKey(key)) {
            if (!freqToFreqNodeMap.containsKey(1)) {
                addFreqNodeNextTo(frequencyList.head, 1);
            }

            keyToKeyNodeMap.put(key, new Node<>(key));
            addKeyToFreq(key, 1);
            return;
        }

        int freq = keyToFreqMap.get(key);
        int nextFreq = freq + 1;

        if (!freqToFreqNodeMap.containsKey(nextFreq)) {
            addFreqNodeNextTo(freqToFreqNodeMap.get(freq), nextFreq);
        }

        removeKeyFromFreq(key, freq);
        addKeyToFreq(key, nextFreq);
    }

    public void dec(String key) {
        if (keyToFreqMap.get(key) == 1) {
            removeKeyFromFreq(key, 1);

            keyToFreqMap.remove(key);
            keyToKeyNodeMap.remove(key);
            return;
        }

        int freq = keyToFreqMap.get(key);
        int prevFreq = freq - 1;

        if (!freqToFreqNodeMap.containsKey(prevFreq)) {
            addFreqNodeNextTo(freqToFreqNodeMap.get(freq).prev, prevFreq);
        }

        removeKeyFromFreq(key, freq);
        addKeyToFreq(key, prevFreq);
    }

    public String getMaxKey() {
        if (frequencyList.isEmpty()) {
            return "";
        }
        return freqToKeyListMap.get(frequencyList.getLast()).getFirst();
    }

    public String getMinKey() {
        if (frequencyList.isEmpty()) {
            return "";
        }
        return freqToKeyListMap.get(frequencyList.getFirst()).getFirst();
    }

    void addKeyToFreq(String key, int freq) {
        keyToFreqMap.put(key, freq);
        freqToKeyListMap.get(freq).add(keyToKeyNodeMap.get(key));
    }

    void removeKeyFromFreq(String key, int freq) {
        freqToKeyListMap.get(freq).remove(keyToKeyNodeMap.get(key));
        if (freqToKeyListMap.get(freq).isEmpty()) {
            removeFreq(freq);
        }
    }

    void removeFreq(int freq) {
        frequencyList.remove(freqToFreqNodeMap.get(freq));
        freqToFreqNodeMap.remove(freq);
        freqToKeyListMap.remove(freq);
    }
    
    void addFreqNodeNextTo(Node<Integer> prevFreqNode, int freq) {
        Node<Integer> freqNode = new Node<>(freq);

        frequencyList.addNextTo(prevFreqNode, freqNode);
        freqToFreqNodeMap.put(freq, freqNode);
        freqToKeyListMap.put(freq, new LinkedList<>());
    }

    class Node<T> {
        T value;

        Node<T> next, prev;

        Node() {}
        Node(T value) {
            this.value = value;
        }
    }

    class LinkedList<T> {
        int size;
        Node<T> head, tail;

        LinkedList() {
            size = 0;

            head = new Node<T>();
            tail = new Node<T>();

            head.next = tail;
            tail.prev = head;
        }

        void add(Node<T> node) {
            size++;

            node.next = head.next;
            head.next.prev = node;

            head.next = node;
            node.prev = head;
        }

        void addNextTo(Node<T> node, Node<T> newNode) {
            size++;

            newNode.next = node.next;
            node.next.prev = newNode;

            node.next = newNode;
            newNode.prev = node;
        }

        void remove(Node<T> node) {
            size--;

            node.next.prev = node.prev;
            node.prev.next = node.next;

            node.next = node.prev = null;
        }

        boolean isEmpty() {
            return size == 0;
        }

        T getFirst() {
            if (isEmpty()) {
                return null;
            }
            return head.next.value;
        }

        T getLast() {
            if (isEmpty()) {
                return null;
            }
            return tail.prev.value;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
