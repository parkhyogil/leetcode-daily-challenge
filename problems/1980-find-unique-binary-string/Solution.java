class Solution {
    public String findDifferentBinaryString(String[] nums) {
        return recur(0, new char[nums.length], nums);
    }

    private String recur(int idx, char[] chars, String[] nums) {
        if (idx == chars.length) {
            String s = String.valueOf(chars);
            for (String t : nums) {
                if (s.equals(t)) {
                    return null;
                }
            }
            return s;
        }

        chars[idx] = '0';
        String res = recur(idx + 1, chars, nums);

        if (res == null) {
            chars[idx] = '1';
            res = recur(idx + 1, chars, nums);
        }
        return res;
    }
}
