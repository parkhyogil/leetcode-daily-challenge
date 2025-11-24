class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] arr = new int[3];

        for (int num : nums) {
            int[] prev = new int[] {arr[0], arr[1], arr[2]};

            for (int sum : prev) {
                arr[(sum + num) % 3] = Math.max(sum + num, arr[(sum + num) % 3]);
            }
        }

        return arr[0];
    }
}
