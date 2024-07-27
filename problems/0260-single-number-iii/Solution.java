class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;

        for (int num : nums) {
            x ^= num;
        }

        int y = 1;

        while ((x & y) == 0) {
            y <<= 1;
        }   

        int first = 0;
        int second = 0;

        for (int num : nums) {
            if ((y & num) == 0) {
                first ^= num;
            } else {
                second ^= num;
            }
        }

        return new int[] {first, second};
    }
}
