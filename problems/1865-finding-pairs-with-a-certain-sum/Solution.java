class FindSumPairs {
    private int[] nums;
    private Map<Integer, Integer> map1, map2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        nums = nums2;

        map1 = new HashMap<>();
        map2 = new HashMap<>();

        for (int num : nums1) {
            map1.merge(num, 1, Integer::sum);
        }
        for (int num : nums2) {
            map2.merge(num, 1, Integer::sum);
        }
    }
    
    public void add(int index, int val) {
        map2.merge(nums[index], -1, Integer::sum);
        map2.merge(nums[index] + val, 1, Integer::sum);

        nums[index] += val;
    }
    
    public int count(int tot) {
        int result = 0;

        for (int num : map1.keySet()) {
            result += map2.getOrDefault(tot - num, 0) * map1.get(num);
        }

        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
