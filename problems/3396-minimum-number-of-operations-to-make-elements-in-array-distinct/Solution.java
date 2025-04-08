class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        
        int[] count = new int[101];

        int duplicatedNums = 0;

        for (int num : nums) {
            if (count[num] > 0) {
                duplicatedNums++;
            }
            count[num]++;
        }

        int operations = 0;
        int idx = 0;

        while (duplicatedNums > 0) {
            for (int i = 0; i < 3 && idx < n; i++) {
                count[nums[idx]]--;
                if (count[nums[idx]] > 0) {
                    duplicatedNums--;
                }
                idx++;
            }
            operations++;
        }

        return operations;
    }
}
