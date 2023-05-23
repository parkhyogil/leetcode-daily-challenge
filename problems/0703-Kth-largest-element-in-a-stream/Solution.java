class KthLargest {
    private int[] heap;
    private int capacity, last;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        heap = new int[capacity + 1];
        last = 0;

        for (int num : nums) {
            push(num);
        }    
    }
    
    public int add(int val) {
        push(val);
        return heap[1];
    }

    private void push(int val) {
        if (last == capacity) {
            if (val > heap[1]) {
                heap[1] = val;
                siftDown(1);
            }
        } else {
            heap[++last] = val;
            siftUp(last);
        }
    }

    private void siftUp(int node) {
        while (node > 1) {
            int parent = node / 2;
            if (heap[parent] < heap[node]) {
                break;
            }
            swap(node, parent);
            node = parent;
        }
    }

    private void siftDown(int node) {
        while (node * 2 <= last) {
            int child = node * 2;
            if (child + 1 <= last && heap[child] > heap[child + 1]) {
                child++;
            }
            if (heap[child] > heap[node]) {
                break;
            }
            swap(node, child);
            node = child;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
