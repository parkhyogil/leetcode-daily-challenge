class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int prev = 0;

        Arrays.sort(arr);

        for (int x : arr) {
            if (x > prev) {
                prev++;
            }
        }

        return prev;
    }
}
