class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;

        int min = 1;
        int max = 1; 

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }

        int res = 0;

        while (min <= max) {
            while (min < max && count[min] == 0) {
                min++;
            }
            while (min < max && count[max] == 0) {
                max--;
            }

            if (min == max) {
                if (count[min] > 0) {
                    res = Math.max(res, min + max);
                }
                return res;
            }

            int pair = Math.min(count[min], count[max]);

            count[min] -= pair;
            count[max] -= pair;

            res = Math.max(res, min + max);
        }

        return -1;
    }
}
