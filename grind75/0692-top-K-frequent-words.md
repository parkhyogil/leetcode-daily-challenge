# [692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)

## Intuition
Heap 자료구조를 이용해 `O(nlogk)` 시간 복잡도로 문제를 해결할 수 있다.\
Heap의 크기를 `k`로 고정하고, 용량이 초과하면 빈도가 작은 단어부터 제거해 상위 빈도 `k`개의 단어를 찾는다.

## Algorithm
1. HashMap `freqOf`에 단어별로 빈도 수를 저장한다.
2. Heap `heap`에 중복이 제거된 단어를 삽입한다. `heap` 용량이 초과하면 빈도가 작은 단어부터 제거된다.
3. List `res`에 `heap`에 남아있는 단어를 저장하고 리턴한다.

## Implementation
```java
class Solution {
    private int capacity, size;
    private String[] heap;
    
    private Map<String, Integer> freqOf;

    public List<String> topKFrequent(String[] words, int k) {
        capacity = k;
        size = 0;
        heap = new String[k + 1];

        countFrequency(words);

        for (String word : freqOf.keySet()) {
            offer(word);
        }

        List<String> res = new ArrayList<>(size);

        while (size > 0) {
            res.add(poll());
        }

        Collections.reverse(res);

        return res;
    }

    private void offer(String word) {
        if (size < capacity) {
            heap[++size] = word;
            siftUp(size);
        } else if (compare(word, heap[1]) > 0) {
            heap[1] = word;
            siftDown(1);
        }
    }

    private String poll() {
        String res = heap[1];

        heap[1] = heap[size--];
        siftDown(1);

        return res;
    }

    private void siftUp(int idx) {
        if (idx == 1) {
            return;
        }

        int parent = idx / 2;

        if (compare(heap[idx], heap[parent]) < 0) {
            swap(idx, parent);
            siftUp(parent);
        }
    }

    private void siftDown(int idx) {
        if (size / 2 < idx) {
            return;
        }

        int child = idx * 2;

        if (child + 1 <= size && compare(heap[child + 1], heap[child]) < 0) {
            child++;
        }

        if (compare(heap[child], heap[idx]) < 0) {
            swap(child, idx);
            siftDown(child);
        }
    }

    private void swap(int i, int j) {
        String tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private int compare(String a, String b) {
        if (freqOf.get(a) == freqOf.get(b)) {
            return b.compareTo(a);
        }
        return Integer.compare(freqOf.get(a), freqOf.get(b));
    }

    private void countFrequency(String[] words) {
        freqOf = new HashMap<>();

        for (String word : words) {
            freqOf.put(word, freqOf.getOrDefault(word, 0) + 1);
        }
    }
}
```

## Complexity
`n`은 `words`의 길이.
- Time complexity: O(nlogk)
- Space complexity: O(n)
