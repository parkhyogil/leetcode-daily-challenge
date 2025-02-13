class Solution {
    public int minOperations(int[] nums, int k) {
        Heap minHeap = new Heap(nums);

        int operations = 0;

        while (minHeap.top() < k) {
            long x = minHeap.pop();
            long y = minHeap.pop();

            minHeap.push(Math.min(x, y) * 2 + Math.max(x, y));
            operations++;
        }

        return operations;
    }

    class Heap {
        private int size;
        private long[] values;

        public Heap(int[] nums) {
            size = nums.length;
            values = new long[size + 1];

            for (int i = 0; i < size; i++) {
                values[i + 1] = nums[i];
            }
            
            heapify();
        }

        public void push(long value) {
            values[++size] = value;
            siftUp(size);
        }

        public long pop() {
            long result = values[1];

            values[1] = values[size--];
            siftDown(1);

            return result;
        }

        public long top() {
            return values[1];
        }

        private void heapify() {
            for (int i = size / 2; i > 0; i--) {
                siftDown(i);
            }
        }

        private void siftUp(int idx) {
            int parent = idx / 2;
            if (idx == 1 || values[idx] >= values[parent]) {
                return;
            }

            swap(idx, parent);
            siftUp(parent);
        }

        private void siftDown(int idx) {
            int child = idx * 2;

            if (child > size) {
                return;
            }

            if (child + 1 <= size && values[child] > values[child + 1]) {
                child++;
            }

            if (values[idx] < values[child]) {
                return;
            }

            swap(idx, child);
            siftDown(child);
        }

        private void swap(int a, int b) {
            long tmp = values[a];
            values[a] = values[b];
            values[b] = tmp;
        }
    }
}
