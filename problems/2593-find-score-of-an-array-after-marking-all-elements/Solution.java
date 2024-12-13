class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();

        long score = 0L;

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (stack.isEmpty() || nums[stack.peek()] > num) {
                stack.push(i);
            } else {
                int j = stack.pop();
                score += nums[j];

                if (!stack.isEmpty() && stack.peek() == j - 1) {
                    stack.pop();
                }
                if (j + 1 < i) {
                    stack.push(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            score += nums[j];

            if (!stack.isEmpty() && stack.peek() == j - 1) {
                stack.pop();
            }
        }

        return score;
    }
}
