class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;

        int res = arr[0];
        int win = 0;

        for (int i = 1; i < n && win < k; i++) {
            if (arr[i] > res) {
                win = 0;
                res = arr[i];
            }
            win++;
        }

        return res;
    }
}
