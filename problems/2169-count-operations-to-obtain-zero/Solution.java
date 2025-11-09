class Solution {
    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }

        int i;
        if (num1 >= num2) {
            i = num1 / num2;
            num1 -= num2 * i;
        } else {
            i = num2 / num1;
            num2 -= num1 * i;
        }

        return i + countOperations(num1, num2);
    }
}
