class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;

        int[] count = new int[1001];

        for (int num : arr1) {
            count[num]++;
        }

        int[] res = new int[n];
        int idx = 0;

        for (int i = 0; i < arr2.length; i++) {
            while (count[arr2[i]] > 0) {
                res[idx++] = arr2[i];
                count[arr2[i]]--;
            }
        }

        for (int i = 0; i <= 1000; i++) {
            while (count[i] > 0) {
                res[idx++] = i;
                count[i]--;
            }
        }

        return res;
    }
}
