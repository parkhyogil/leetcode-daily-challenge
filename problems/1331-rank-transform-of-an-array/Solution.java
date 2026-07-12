class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        list.sort((a, b) -> arr[a] - arr[b]);

        int[] result = new int[n];
        result[list.get(0)] = 1;

        for (int i = 1; i < n; i++) {
            result[list.get(i)] = result[list.get(i - 1)];

            if (arr[list.get(i)] > arr[list.get(i - 1)]) {
                result[list.get(i)]++;
            }
        }
        
        return result;
    }
}
