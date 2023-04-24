class Solution {
    public int lastStoneWeight(int[] stones) {
        MyHeap q = new MyHeap(stones);

        while (q.size() > 1) {
            int newStone = q.poll() - q.poll();
            if (newStone > 0) {
                q.offer(newStone);
            }
        }
        return q.isEmpty() ? 0 : q.poll();
    }

    class MyHeap {
        private int[] heap;
        private int size;

        public MyHeap(int[] nums) {
            int n = nums.length;

            heap = new int[n + 1];
            size = n;

            for (int i = 0; i < n; i++) {
                heap[i + 1] = nums[i];
            }

            for (int i = size / 2; i > 0; i--) {
                siftDown(i);
            }
        }

        public void offer(int num) {
            heap[++size] = num;
            siftUp(size);
        }

        public int poll() {
            int res = heap[1];
            heap[1] = heap[size--];
            siftDown(1);
            return res;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void siftUp(int idx) {
            while (idx > 1) {
                int parent = idx / 2;
                if (heap[idx] <= heap[parent]) {
                    break;
                }
                swap(idx, parent);
                idx = parent;
            }
        }

        private void siftDown(int idx) {
            while (idx <= size / 2) {
                int child = idx * 2;
                if (child + 1 <= size && heap[child] < heap[child + 1]) {
                    child++;
                }
                if (heap[idx] >= heap[child]) {
                    break;
                }
                swap(idx, child);
                idx = child;
            }
        }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }
}
