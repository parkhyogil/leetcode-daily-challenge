class Solution {
    public int maxSum(int[] nums) {
        boolean[] visited = new boolean[101];

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > 0 && !visited[num]) {
                sum += num;
                visited[num] = true;
            }
            max = Math.max(max, num);
        }

        return max < 0 ? max : sum;
    }
}
