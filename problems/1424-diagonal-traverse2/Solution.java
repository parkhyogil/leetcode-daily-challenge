class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int size = 0;
        List<List<Integer>> sorted = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            size += nums.get(i).size();

            for (int j = 0; j < nums.get(i).size(); j++) {
                if (sorted.size() == i + j) {
                    sorted.add(new ArrayList<>());
                }
                sorted.get(i + j).add(nums.get(i).get(j));
            }
        }

        int[] res = new int[size];
        int idx = 0;

        for (int i = 0; i < sorted.size(); i++) {
            for (int j = sorted.get(i).size() - 1; j >= 0; j--) {
                res[idx++] = sorted.get(i).get(j);
            }
        }

        return res;
    }
}
