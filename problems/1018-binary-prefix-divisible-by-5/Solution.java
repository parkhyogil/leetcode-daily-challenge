class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();

        int x = 0;
        for (int num : nums) {
            x = (x * 2 + num) % 5;
            result.add(x == 0);
        }

        return result;
    }
}
