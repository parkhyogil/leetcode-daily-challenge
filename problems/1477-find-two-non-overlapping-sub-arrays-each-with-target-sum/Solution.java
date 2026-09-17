class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] min = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();

        min[0] = n + 1;
        map.put(0, -1);

        int sum = 0;

        int result = n + 1;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            min[i + 1] = min[i];

            if (map.containsKey(sum - target)) {
                int j = map.get(sum - target);
                int len = i - j;

                result = Math.min(result, len + min[j + 1]);
                min[i + 1] = Math.min(len, min[i]);
            }

            map.put(sum, i);
        }

        return result > n ? -1 : result;
    }
}
