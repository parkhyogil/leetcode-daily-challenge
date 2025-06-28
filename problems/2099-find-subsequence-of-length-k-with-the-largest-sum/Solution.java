class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        int[] arr = Arrays.copyOf(nums, n);
        quickSelect(arr, n - k - 1);

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = n - k; i < n; i++) {
            freqMap.merge(arr[i], 1, Integer::sum);
        }

        int[] result = new int[k];

        for (int i = 0, j = 0; i < n; i++) {
            int num = nums[i];
            if (freqMap.getOrDefault(num, 0) > 0) {
                result[j++] = nums[i];
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }

        return result;
    }

    private void quickSelect(int[] arr, int k) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int partitionIdx = partition(l, r, arr, k);

            if (partitionIdx == k) {
                return;
            } else if (partitionIdx < k) {
                l = partitionIdx + 1;
            } else {
                r = partitionIdx - 1;
            }
        }
    }

    private int partition(int l, int r, int[] arr, int k) {
        swap((l + r) / 2, r, arr);

        int i = l - 1; 
        for (int j = l; j < r; j++) {
            if (arr[j] <= arr[r]) {
                swap(++i, j, arr);
            }
        }

        swap(++i, r, arr);

        return i;
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
