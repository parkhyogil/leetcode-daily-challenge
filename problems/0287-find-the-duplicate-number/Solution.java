class Solution {
    public int findDuplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int tmp = nums[0];
            nums[0] = nums[nums[0]];
            nums[tmp] = tmp;
        }

        return nums[0];
    }
}
