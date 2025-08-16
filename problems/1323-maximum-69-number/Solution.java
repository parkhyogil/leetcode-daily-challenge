class Solution {
    public int maximum69Number (int num) {
        int i = 0;

        for (int j = 1; j < num; j *= 10) {
            if (num / j % 10 == 6) {
                i = j;
            }
        }

        return num + i * 3;
    }
}
