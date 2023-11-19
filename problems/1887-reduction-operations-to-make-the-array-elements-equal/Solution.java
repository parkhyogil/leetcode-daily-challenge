class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;

        sort(nums);

        int res = 0;

        int max = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < max) {
                res += n - 1 - i;
                max = nums[i];
            }
        }

        return res;
    }

    private void sort(int[] nums) {
        int[] count = new int[50000 + 1];

        for (int num : nums) {
            count[num]++;
        }

        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            while (count[min] == 0) {
                min++;
            }
            
            nums[i] = min;
            count[min]--;
        }
    }
}
