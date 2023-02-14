class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, s, new int[4], res);
        return res;
    }

    private void backtrack(int depth, int idx, String s, int[] nums, List<String> res) {
        if (depth == 4 || idx == s.length()) {
            if (depth == 4 && idx == s.length()) {
                res.add(convertToString(nums));
            }
            return;
        }

        if (s.charAt(idx) == '0') {
            nums[depth] = 0;
            backtrack(depth + 1, idx + 1, s, nums, res);
            return;
        }

        nums[depth] = 0;
        for (int i = idx; i < idx + 3 && i < s.length(); i++) {
            nums[depth] = nums[depth] * 10 + s.charAt(i) - '0';
            if (nums[depth] < 256) {
                backtrack(depth + 1, i + 1, s, nums, res);
            }
        }
    }

    private String convertToString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(nums[i]);
            if (i < 3) {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}
