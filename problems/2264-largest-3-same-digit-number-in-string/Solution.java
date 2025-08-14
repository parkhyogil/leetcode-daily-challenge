class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();

        int idx = -1;

        for (int i = 0; i < n - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2) && (idx == -1 || num.charAt(idx) < num.charAt(i))) {
                idx = i;
            }
        }

        return idx < 0 ? "" : num.substring(idx, idx + 3);
    }
}
