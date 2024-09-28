class MyCircularDeque {
    private int capacity, size, front, rear;
    private int[] values;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
        front = 0;
        rear = capacity - 1;

        values = new int[capacity];
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        size++;

        values[(front = getIndex(front, -1))] = value;

        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        size++;

        values[(rear = getIndex(rear, 1))] = value;

        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        size--;

        front = getIndex(front, 1);

        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        size--;

        rear = getIndex(rear, -1);

        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return values[front];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return values[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }

    private int getIndex(int prevIndex, int offset) {
        return (capacity + prevIndex + offset) % capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
