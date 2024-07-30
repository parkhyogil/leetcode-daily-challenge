class Solution {
    public int minimumDeletions(String s) {
        int aCount = 0;
        int bCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCount++;
            }
        }

        int res = s.length();

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCount--;
            }

            res = Math.min(res, aCount + bCount);

            if (c == 'b') {
                bCount++;
            }
        }

        return res;
    }
}
