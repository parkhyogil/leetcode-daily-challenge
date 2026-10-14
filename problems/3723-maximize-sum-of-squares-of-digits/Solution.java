class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (num * 9 < sum) {
            return "";
        }

        char[] arr = new char[num];

        for (int i = 0; i < num; i++) {
            arr[i] = (char) (Math.min(9, sum) + '0');
            sum -= Math.min(9, sum);
        }

        return String.valueOf(arr);
    }
}
