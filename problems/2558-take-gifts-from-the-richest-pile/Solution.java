import java.util.Collections;
import java.util.Comparator;

class Solution {
    static class Heap<T> {
        private int capacity, size;
        private Object[] values;
        private Comparator<T> comparator;

        public Heap(int capacity, Comparator<T> comparator) {
            this.capacity = capacity;
            this.size = 0;
            this.comparator = comparator;

            values = new Object[capacity + 1];
        }


        public void push(T value) {
            siftUp(++size, value);
        }

        public T pop() {
            T result = (T) values[1];

            T lastValue = (T) values[size];
            values[size--] = null;

            siftDown(1, lastValue);

            return result;
        }

        private void siftUp(int i, T value) {
            while (i > 1) {
                int j = i / 2;

                if (comparator.compare((T) values[j], value) <= 0) {
                    break;
                }

                values[i] = values[j];
                i = j;
            }
            values[i] = value;
        }

        private void siftDown(int i, T value) {
            while (i * 2 <= size) {
                int j = i * 2;
                
                Object child = values[j];
                if (j + 1 <= size && comparator.compare((T) child, (T) values[j + 1]) > 0) {
                    child = values[++j];
                }

                if (comparator.compare(value, (T) child) <= 0) {
                    break;
                }
                
                values[i] = child;
                i = j;
            }
            values[i] = value;
        }
    }

    public long pickGifts(int[] gifts, int k) {
        Heap<Integer> maxHeap = new Heap<>(gifts.length, Collections.reverseOrder());

        long result = 0;

        for (int gift : gifts) {
            result += gift;
            maxHeap.push(gift);
        }

        for (int i = 0; i < k; i++) {
            int richest = maxHeap.pop();

            result += (int) Math.sqrt(richest) - richest;
            maxHeap.push((int) Math.sqrt(richest));
        }

        return result;
    }
}
