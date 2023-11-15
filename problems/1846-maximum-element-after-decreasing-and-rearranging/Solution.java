class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;

        int[] count = new int[n + 1];
        for (int num : arr) {
            count[Math.min(n, num)]++;
        }

        int res = 1;
        for (int num = 2; num <= n; num++) {
            res = Math.min(num, res + count[num]);
        }
        return res;
    }
}
