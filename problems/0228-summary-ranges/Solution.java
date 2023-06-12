class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;

        List<String> res = new ArrayList<>();

        for (int a = 0; a < n;) {
            int b = a;

            while (b + 1 < n && nums[b] + 1 == nums[b + 1]) {
                b++;
            }

            if (a != b) {
                res.add(nums[a] + "->" + nums[b]);
            } else {
                res.add(String.valueOf(nums[a]));
            }
            a = b + 1;
        }
        return res;
    }
}
