class Solution {
    public int minPatches(int[] nums, int n) {
        long sum = 0;        
        int res = 0;

        for (int num : nums) {
            while (sum < num - 1 && sum < n) {
                sum += sum + 1;
                res++;
            }
            
            sum += num;
            
            if (sum >= n) {
                break;
            }
        }

        while (sum < n) {
            sum += sum + 1;
            res++;
        }

        return res;
    }
}
