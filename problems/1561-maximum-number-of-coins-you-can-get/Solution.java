class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length / 3;

        sort(piles);

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += piles[1 + i * 2];
        }

        return res;
    }

    private void sort(int[] nums) {
        int max = 10000;

        int[] count = new int[max + 1];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 0; i < nums.length; i++) {
            while (count[max] == 0) {
                max--;
            }

            nums[i] = max;
            count[max]--;
        }
    }
}
