class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();

        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        int result = 0;

        for (int i = 1; i < m; i++) {
            List<Integer> array = arrays.get(i);

            int arrayMin = array.get(0);
            int arrayMax = array.get(array.size() - 1);

            result = Math.max(result, Math.max(Math.abs(min - arrayMax), Math.abs(max - arrayMin)));

            min = Math.min(min, arrayMin);
            max = Math.max(max, arrayMax);
        }

        return result;
    }
}
