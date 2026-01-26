class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            minDiff = Math.min(arr[i + 1] - arr[i], minDiff);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }

        return result;
    }
}
