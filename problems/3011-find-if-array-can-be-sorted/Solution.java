class Solution {
    public boolean canSortArray(int[] nums) {
        int prevMax = 0;

        int currMax = 0;
        int currBitCount = 0;

        for (int num : nums) {
            if (currBitCount != Integer.bitCount(num)) {
                prevMax = currMax;

                currMax = num;
                currBitCount = Integer.bitCount(num);
            } else {
                currMax = Math.max(currMax, num);
            }

            if (num < prevMax) {
                return false;
            }
        }

        return true;
    }
}
