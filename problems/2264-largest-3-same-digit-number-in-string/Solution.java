class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();

        String res = "";

        for (int l = 0, r = 0; r < n; r++) {
            while (num.charAt(l) != num.charAt(r)) {
                l++;
            }

            if ((r - l + 1 == 3) && (res.isEmpty() || res.charAt(0) < num.charAt(l))) {
                res = num.substring(l, r + 1);
            }
        }

        return res;
    }
}
