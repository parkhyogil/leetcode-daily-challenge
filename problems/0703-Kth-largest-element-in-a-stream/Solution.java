class KthLargest {
    private int capacity, size;
    private int[] heap;

    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        this.size = 0;
        heap = new int[k + 1];

        for (int num : nums) {
            push(num);
        }
    }
    
    public int add(int val) {
        push(val);
        return heap[1];
    }

    private void push(int num) {
        if (size < capacity) {
            heap[++size] = num;
            siftUp(size);
        } else if (num > heap[1]) {
            heap[1] = num;
            siftDown(1);
        }
    }

    private void siftUp(int idx) {
        if (idx == 1) {
            return;
        }

        int parent = idx / 2;

        if (heap[idx] < heap[parent]) {
            swap(idx, parent);
            siftUp(parent);
        }
    }

    private void siftDown(int idx) {
        int child = idx * 2;

        if (child > size) {
            return;
        }

        if (child + 1 <= size && heap[child + 1] < heap[child]) {
            child++;
        }

        if (heap[idx] > heap[child]) {
            swap(idx, child);
            siftDown(child);
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
