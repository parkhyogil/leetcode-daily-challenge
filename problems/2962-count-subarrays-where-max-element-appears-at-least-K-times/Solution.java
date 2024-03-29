class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;

        int max = 0;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        long res = 0;
        int count = 0;
        
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] == max) {
                count++;
            }

            while (count >= k) {
                if (count == k && nums[l] == max) {
                    break;
                }
                if (nums[l] == max) {
                    count--;
                }
                l++;
            }

            if (count == k) {
                res += l + 1;
            }
        }

        return res;
    }
}
