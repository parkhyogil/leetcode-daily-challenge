class Solution {
    public long maxKelements(int[] nums, int k) {
        Heap maxHeap = new Heap(nums);

        long result = 0L;

        for (int i = 0; i < k; i++) {
            int maxValue = maxHeap.pop();

            result += maxValue;

            maxHeap.push((maxValue + 2) / 3);
        }

        return result;
    }
}

class Heap {
    private int size;
    private int[] values;

    public Heap(int[] nums) {
        int n = nums.length;

        size = n;
        values = new int[n + 1];
        System.arraycopy(nums, 0, values, 1, n);

        for (int i = n / 2; i >= 1; i--) {
            siftDown(i);
        }
    }

    public void push(int value) {
        values[++size] = value;
        siftUp(size);
    }

    public int pop() {
        int result = values[1];

        values[1] = values[size--];

        siftDown(1);

        return result;
    }

    private void siftUp(int idx) {
        while (idx > 1 && values[idx] > values[idx / 2]) {
            swap(idx, idx / 2);
            idx /= 2;
        }
    }

    private void siftDown(int idx) {
        while (idx * 2 <= size) {
            int child = idx * 2;
            if (child + 1 <= size && values[child] < values[child + 1]) {
                child++;
            }

            if (values[idx] >= values[child]) {
                return;
            }

            swap(idx, child);
            idx = child;
        }
    }

    private void swap(int i, int j) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
