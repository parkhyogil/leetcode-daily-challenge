class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] contains = new boolean[1001];

        for (int num : nums1) {
            contains[num] = true;
        }

        List<Integer> list = new ArrayList<>();

        for (int num : nums2) {
            if (contains[num]) {
                contains[num] = false;
                list.add(num);
            }
        }

        return list.stream().mapToInt(a -> a.intValue()).toArray();
    }
}
