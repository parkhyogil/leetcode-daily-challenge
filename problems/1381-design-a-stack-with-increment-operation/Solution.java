class CustomStack {
    private int capacity, index;
    private int[] stack, incrementStack;

    public CustomStack(int maxSize) {
        capacity = maxSize;
        index = -1;

        stack = new int[capacity];
        incrementStack = new int[capacity];
    }
    
    public void push(int x) {
        if (isFull()) {
            return;
        }
        stack[++index] = x;
    }
    
    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int incrementVal = incrementStack[index];
        incrementStack[index] = 0;

        stack[index] += incrementVal;

        if (index > 0) {
            incrementStack[index - 1] += incrementVal;
        }

        return stack[index--];
    }
    
    public void increment(int k, int val) {
        if (isEmpty()) {
            return;
        }
        incrementStack[Math.min(k - 1, index)] += val;
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public boolean isFull() {
        return index + 1 == capacity;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
