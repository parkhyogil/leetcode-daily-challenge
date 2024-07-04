# [146. LRU Cache](https://leetcode.com/problems/lru-cache/description/)

## Intuition
값의 입력 순서는 중요하다. 용량이 다 찼을 때 새로운 값이 들어오면 가장 오래된 값이 삭제되어야 한다. 
또한 삭제가 빨라야 한다. 이미 저장된 값을 검색하거나 업데이트할 때 기존 값의 위치를 삭제하고 리스트의 마지막 위치에 삽입해야 한다.\
LinkedList와 HashMap을 사용하면 데이터를 선형으로 관리할 수 있으며, 데이터에 빠르게 접근하고 삭제할 수 있다.

## Algorithm
- `Node` 클래스
  - LinkedList로 사용한다.
  - 키와 값, 이전 노드 포인터와 다음 노드 포인터를 갖는다.
- `LRUCache` 클래스
  - 필드
    - `int capacity` : 캐시의 용량.
    - `int size` : 캐시의 현재 크기.
    - `Node head` : LinkedList의 첫번째 노드.
    - `Node tail` : LinkedList의 마지막 노드.
    - `HashMap<Integer, Node> nodeMap` : 데이터에 빠르게 접근하기 위해 노드의 키를 해시맵의 키로 사용하고, 노드를 값으로 사용하는 해시맵.
  - 생성자
    - 전달받은 용량을 캐시의 용량으로 설정하고, 크기를 `0`으로 초기화한다.
    - `head`와 `tail` 노드를 더미 노드로 생성하고, 두 노드를 연결한다.
    - `nodeMap`을 초기화한다.
  - 메소드
    - `get(int key)`
      - `nodeMap`에 해당 키가 없다면 `-1`를 리턴한다.
      - 찾은 노드를 리스트의 마지막으로 옮기고 노드의 값을 리턴한다.
    - `put(int key, int value)`
      - `nodeMap`에 해당 키가 있다면 노드의 값을 변경하고 노드를 리스트의 마지막으로 옮긴다.
      - `add` 메소드를 호출해 노드를 추가하고 캐시 용량이 초과하면 오래된 노드를 제거한다.
    - `add(Node node)`
      - `nodeMap`에 키와 노드를 추가한다.
      - `tail` 더미 노드와 그 이전 노드 사이에 새 노드를 연결하고 캐시 크기를 증가시킨다.
    - `remove(Node node)`
      - `nodeMap`에 키와 노드를 제거한다.
      - 삭제할 노드의 이전 노드와 다음 노드를 연결하고 캐시 크기를 감소시킨다.
    - `moveToTail(Node node)`
      - 노드를 `remove` 메소드로 제거하고 `add` 메소드를 호출해 노드를 리스트의 마지막으로 옮긴다.
  
## Implementation
```java
class LRUCache {
    class Node {
        private int key, value;
        private Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    
    private int capacity, size;
    private Node head, tail;
    private Map<Integer, Node> nodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;

        nodeMap = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
    
        Node node = nodeMap.get(key);
    
        moveToTail(node);
    
        return node.getValue();
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.setValue(value);

            moveToTail(node);
        } else {
            add(new Node(key, value));

            if (size > capacity) {
                remove(head.next);
            }
        }
    }

    private void add(Node node) {
        nodeMap.put(node.getKey(), node);

        tail.prev.next = node;
        node.prev = tail.prev;

        tail.prev = node;
        node.next = tail;

        size++;
    }

    private void remove(Node node) {
        nodeMap.remove(node.getKey());

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;

        size--;
    }

    private void moveToTail(Node node) {
        remove(node);
        add(node);
    }
}
```

## Complexity
- Time complexity: O(1)
  - 작성된 메소드는 모두 O(1)의 시간 복잡도를 갖는다.

