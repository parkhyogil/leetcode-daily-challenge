class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;

        countSort(nums);

        int result = 0;

        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && nums[j] - nums[i] <= k) {
                j++;
            }

            result++;
        }

        return result;
    }

    public void countSort(int[] arr) {
        int max = 0;

        for (int num : arr) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        for (int i = 0, j = 0; i < arr.length; i++) {
            while (count[j] == 0) {
                j++;
            }
            arr[i] = j;
            count[j]--;
        }
    }
}
