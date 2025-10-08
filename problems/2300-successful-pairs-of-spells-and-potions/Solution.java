class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;

        Arrays.sort(potions);

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = binarySearch(spells[i], success, potions);
        }

        return result;
    }

    int binarySearch(int t, long s, int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if ((long) t * arr[mid] < s) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return arr.length - 1 - hi;
    }
}
