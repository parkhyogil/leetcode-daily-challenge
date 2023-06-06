class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if ((max - min) % (n - 1) != 0) {
            return false;
        }

        int diff = (max - min) / (n - 1);

        int idx = 0;
        while (idx < n) {
            if (arr[idx] == min + idx * diff) {
                idx++;
            } else if ((arr[idx] - min) % diff != 0) {
                return false;
            } else {
                int j = (arr[idx] - min) / diff;

                if (arr[idx] == arr[j]) {
                    return false;
                }
                swap(idx, j, arr);
            }
        }
        return true;
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
