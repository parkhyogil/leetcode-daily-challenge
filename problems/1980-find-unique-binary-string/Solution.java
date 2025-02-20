class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();

        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }

        int result = 0;

        while (set.contains(result)) {
            result++;
        }

        return toBinaryString(result, n);
    }

    String toBinaryString(int num, int length) {
        char[] chars = new char[length];

        for (int i = length - 1; i >= 0; i--) {
            chars[i] = num % 2 == 0 ? '0' : '1';
            num /= 2;
        }

        return String.valueOf(chars);
    }
}
