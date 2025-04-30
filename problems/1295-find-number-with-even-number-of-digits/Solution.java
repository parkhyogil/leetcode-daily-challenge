class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;

        for (int num : nums) {
            if (isEvenDigits(num)) {
                result++;
            }
        }

        return result;
    }

    private boolean isEvenDigits(int num) {
        return (int) Math.log10(num) % 2 == 1;
    }
}
