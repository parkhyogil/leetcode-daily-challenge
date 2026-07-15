class Solution {
    public int gcdOfOddEvenSums(int n) {
        int s = n * 2 * (n * 2 + 1) / 2;

        int a = (s - n) / 2;
        int b = s - a;

        while (b > 0) {
            int t = a % b;
            a = b;
            b = t;
        }

        return a;
    }
}
