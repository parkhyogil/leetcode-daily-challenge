class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;

        int[] max = new int[n];
        Arrays.fill(max, 1);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        list.sort((a, b) -> arr[b] - arr[a]);

        int result = 0;

        for (int i : list) {
            int kVal = 0;

            for (int x = 1; x <= d && i - x >= 0 && arr[i] > arr[i - x] && arr[i] > kVal; x++) {
                max[i - x] = Math.max(max[i - x], max[i] + 1);
                kVal = Math.max(kVal, arr[i - x]);
            }

            kVal = 0;
            
            for (int x = 1; x <= d && i + x < n && arr[i] > arr[i + x] && arr[i] > kVal; x++) {
                max[i + x] = Math.max(max[i + x], max[i] + 1);
                kVal = Math.max(kVal, arr[i + x]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }
}
