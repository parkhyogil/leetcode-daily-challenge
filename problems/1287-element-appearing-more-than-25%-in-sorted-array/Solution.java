class Solution {
    public int findSpecialInteger(int[] arr) {
        int target = arr.length / 4;
        
        int prev = -1;
        int count = 0;

        for (int num : arr) {
            if (num == prev) {
                count++;
            } else {
                prev = num;
                count = 1;
            }

            if (count > target) {
                return num;
            }
        }

        return -1;
    }
}
