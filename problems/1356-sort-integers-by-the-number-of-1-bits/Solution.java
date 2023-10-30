class Solution {
    public int[] sortByBits(int[] arr) {
        quickSort(0, arr.length - 1, arr);
        return arr;
    }

    private void quickSort(int left, int right, int[] arr) {
        if (left >= right) {
            return;
        }

        int[] pos = partition(left, right, arr);

        quickSort(left, pos[0], arr);
        quickSort(pos[1], right, arr);
    }

    private int[] partition(int left, int right, int[] arr) {
        int pivot = arr[(left + right) / 2];

        int i = left;
        int j = right;

        while (i <= j) {
            while (compare(arr[i], pivot)) {
                i++;
            }
            while (compare(pivot, arr[j])) {
                j--;
            }

            if (i < j) {
                swap(i++, j--, arr);
            } else {
                i++;
            }
        }
        return new int[] {j, j + 1};
    }

    private boolean compare(int a, int b) {
        int diff = Integer.bitCount(a) - Integer.bitCount(b);

        if (diff == 0) {
            return a < b;
        }
        return diff < 0;
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
