class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int f = 0;
        int i = 0;

        for (int x : nums) {
            if (x < target) {
                i++;
            } else if (x == target) {
                f++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int j = 0; j < f; j++) {
            result.add(i + j);
        }

        return result;
    }
}
