class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = 101;
        int max = 0;
        int[] freq = new int[101];

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            freq[x]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (freq[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}
