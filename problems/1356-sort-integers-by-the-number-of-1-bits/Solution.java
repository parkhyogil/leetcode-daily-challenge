class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i - 1;
            int val = arr[i];

            while (j >= 0) {
                if (compare(arr[j], val) > 0) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
                j--;
            }

            arr[j + 1] = val;
        }

        return arr;
    }

    int compare(int a, int b) {
        int x = Integer.bitCount(a);
        int y = Integer.bitCount(b);

        return x != y ? x - y : a - b;
    }
}
