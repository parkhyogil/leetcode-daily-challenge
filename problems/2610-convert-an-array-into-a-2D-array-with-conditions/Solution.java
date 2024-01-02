class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int[] count = new int[201];

        for (int num : nums) {
            if (res.size() == count[num]) {
                res.add(new ArrayList<>());
            }
            
            res.get(count[num]).add(num);
            count[num]++;
        }

        return res;
    }
}
