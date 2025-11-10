class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int[] stack = new int[n];
        int idx = -1;

        int result = 0;

        for (int num : nums) {
            while (idx > -1 && num < stack[idx]) {
                idx--;
                result++;
            }

            if (idx == -1 || num > stack[idx]) {
                stack[++idx] = num;
            }
        }

        return result + (stack[0] == 0 ? idx : idx + 1);
    }
}
