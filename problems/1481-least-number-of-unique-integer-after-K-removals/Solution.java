class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;

        if (n - k <= 1) {
            return n - k;
        }

        Map<Integer, Integer> countOf = new HashMap<>();
        for (int num : arr) {
            countOf.put(num, countOf.getOrDefault(num, 0) + 1);
        }

        int res = countOf.size();

        List<Integer> values = new ArrayList<>(countOf.values());
        Collections.sort(values);

        for (int val : values) {
            k -= val;
            if (k < 0) {
                break;
            }

            res--;
        }

        return res;
    }
}      
