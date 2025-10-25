class Solution {
    public int totalMoney(int n) {
        int x = n / 7;
        int y = n % 7;

        return sum(28, x, 7) + sum(x + 1, y, 1);
    }

    int sum(int a, int n, int d) {
        return n * (2 * a + (n - 1) * d) / 2;
    }
}
