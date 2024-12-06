class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] bannedNum = new boolean[n + 1];

        for (int num : banned) {
            if (num > n) {
                continue;
            }
            
            bannedNum[num] = true;
        }

        int count = 0;

        for (int i = 1; i <= n && maxSum > 0; i++) {
            if (bannedNum[i]) {
                continue;
            }

            maxSum -= i;

            if (maxSum >= 0) {
                count++;
            }
        }

        return count;
    }
}
