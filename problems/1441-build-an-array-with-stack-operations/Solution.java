class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();

        int num = 1;
        for (int t : target) {
            while (num < t) {
                res.add("Push");
                res.add("Pop");
                num++;
            }
            res.add("Push");
            num++;
        }

        return res;
    }
}
