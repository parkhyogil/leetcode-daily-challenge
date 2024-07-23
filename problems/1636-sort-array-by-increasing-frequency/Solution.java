class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        int[] count = new int[201];

        for (int num : nums) {
            count[num  + 100]++;
        }

        int idx = n - 1;

        while (idx >= 0) {
            int maxNum = -100;

            for (int num = -100; num <= 100; num++) {
                if (count[num + 100] > count[maxNum + 100]) {
                    maxNum = num;
                }
            }

            for (int i = 0; i < count[maxNum + 100]; i++) {
                nums[idx--] = maxNum;
            }
            count[maxNum + 100] = 0;
        }

        return nums;
    }
}
