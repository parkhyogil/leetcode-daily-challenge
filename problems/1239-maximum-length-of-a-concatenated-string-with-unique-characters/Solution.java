class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> bitList = new ArrayList<>();

        for (String s : arr) {
            int bit = parse(s);
            if (bit > 0) {
                bitList.add(bit);
            }
        }

        return recur(0, 0, bitList);
    }

    private int recur(int idx, int bit, List<Integer> bitList) {
        int res = Integer.bitCount(bit);

        for (int i = idx; i < bitList.size(); i++) {
            if ((bit & bitList.get(i)) == 0) {
                res = Math.max(res, recur(i + 1, bit | bitList.get(i), bitList));
            }
        }

        return res;
    }

    private int parse(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = 1 << (s.charAt(i) - 'a');

            if ((res & val) > 0) {
                return 0;
            }

            res |= val;
        }

        return res;
    }
}
