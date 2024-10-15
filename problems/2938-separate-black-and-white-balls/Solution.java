class Solution {
    public long minimumSteps(String s) {
        int left = 0;
        int right = s.length() - 1;

        long result = 0L;
        while (left < right) {
            while (left < right && s.charAt(left) == '0') {
                left++;
            }
            while (left < right && s.charAt(right) == '1') {
                right--;
            }

            result += right - left;

            left++;
            right--;
        }

        return result;
    }
}
