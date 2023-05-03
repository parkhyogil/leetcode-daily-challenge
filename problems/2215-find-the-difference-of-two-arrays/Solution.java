class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(removeDuplicate(nums1, nums2));
        res.add(removeDuplicate(nums2, nums1));
        return res;
    }

    private List<Integer> removeDuplicate(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            set.remove(num);
        }
        return new ArrayList<>(set);
    }
}
