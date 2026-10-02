class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        recur(0, 0, new char[n * 2], result);

        return result;
    }

    void recur(int i, int b, char[] arr, List<String> result) {
        if (b < 0 || b > arr.length - i) {
            return;
        }

        if (i == arr.length) {
            result.add(String.valueOf(arr));
            return;
        }

        arr[i] = '(';
        recur(i + 1, b + 1, arr, result);
        arr[i] = ')';
        recur(i + 1, b - 1, arr, result);
    }
}
