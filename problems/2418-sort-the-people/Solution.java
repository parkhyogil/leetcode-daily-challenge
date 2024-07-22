class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        sort(names, heights);

        return names;
    }

    private void sort(String[] names, int[] heights) {
        int n = names.length;

        // mergeSort(0, n - 1, names, heights, new String[n], new int[n]);
        quickSort(0, n - 1, names, heights);
    }

    private void quickSort(int l, int r, String[] strs, int[] ints) {
        if (l >= r) {
            return;
        }

        int pivotPos = partition(l, r, strs, ints);

        quickSort(l, pivotPos, strs, ints);
        quickSort(pivotPos + 1, r, strs, ints);
    }

    private int partition(int l, int r, String[] strs, int[] ints) {
        int pivotVal = ints[(l + r) / 2];

        int i = l;
        int j = r;

        while (i <= j) {
            while (ints[i] > pivotVal) {
                i++;
            }
            while (ints[j] < pivotVal) {
                j--;
            }

            if (i < j) {
                String tmpStr = strs[i];
                strs[i] = strs[j];
                strs[j] = tmpStr;

                int tmpInt = ints[i];
                ints[i] = ints[j];
                ints[j] = tmpInt;
            } else {
                i++;
            }
        }

        return j;
    }

    private void mergeSort(int l, int r, String[] strs, int[] ints, String[] tmpStrs, int[] tmpInts) {
        if (l >= r) {
            return;
        }

        int m = (l + r) / 2;

        mergeSort(l, m, strs, ints, tmpStrs, tmpInts);
        mergeSort(m + 1, r, strs, ints, tmpStrs, tmpInts);

        merge(l, m, r, strs, ints, tmpStrs, tmpInts);
    }

    private void merge(int l, int m, int r, String[] strs, int[] ints, String[] tmpStrs, int[] tmpInts) {
        System.arraycopy(strs, l, tmpStrs, l, m - l + 1);
        System.arraycopy(ints, l, tmpInts, l, m - l + 1);

        int idx = l;
        int i = l;
        int j = m + 1;

        while (i <= m && j <= r) {
            if (tmpInts[i] >= ints[j]) {
                strs[idx] = tmpStrs[i];
                ints[idx] = tmpInts[i];
                i++;
            } else {
                strs[idx] = strs[j];
                ints[idx] = ints[j];
                j++;
            }
            idx++;
        }

        while (i <= m) {
            strs[idx] = tmpStrs[i];
            ints[idx] = tmpInts[i];
            idx++;
            i++;
        }
    }
}
