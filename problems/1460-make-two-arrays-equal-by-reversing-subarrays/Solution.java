class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] values = new int[1001];

        for (int val : target) {
            values[val]++;
        }

        for (int val : arr) {
            values[val]--;

            if (values[val] < 0) {
                return false;
            }
        }

        return true;
    }
}
