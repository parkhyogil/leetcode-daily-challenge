class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;

        while (left != right) {
            left /= 2;
            right /= 2;
            count++;
        }

        return left << count;
    }
}
