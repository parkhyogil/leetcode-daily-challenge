class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];

        for (int num : nums1) {
            count[num]++;
        }

        List<Integer> intersectList = new ArrayList<>();

        for (int num : nums2) {
            if (count[num] > 0) {
                intersectList.add(num);
                count[num]--;
            }
        }

        return intersectList.stream().mapToInt(Integer::intValue).toArray();
    }
}
