class Solution {
    private int[] count, unique;
    
    public int[] topKFrequent(int[] nums, int k) {
        int n = 0;

        count = new int[20001];
        for (int num : nums) {
            if (count[num + 10000] == 0) {
                n++;
            }
            count[num + 10000]++;
        }

        unique = new int[n];
        for (int num = -10000, i = 0; num <= 10000; num++) {
            if (count[num + 10000] > 0) {
                unique[i++] = num;
            }
        }
        
        quickSelect(0, n - 1, k - 1);
        return Arrays.copyOf(unique, k);
    }

    private int partition(int lo, int hi) {
        int pivot = count[unique[hi] + 10000];

        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (count[unique[j] + 10000] > pivot) {
                swap(i++, j);
            }
        }
        swap(i, hi);
        return i;
    }

    private void quickSelect(int lo, int hi, int k) {
        if (lo == hi) {
            return;
        }
        
        int pos = partition(lo, hi);
        if (pos == k) {
            return;
        } else if (k < pos) {
            quickSelect(lo, pos - 1, k);
        } else {
            quickSelect(pos + 1, hi, k);
        }
    }

    private void swap(int i, int j) {
        int tmp = unique[i];
        unique[i] = unique[j];
        unique[j] = tmp;
    }
}
