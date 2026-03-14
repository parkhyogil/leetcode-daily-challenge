class Solution {
    public String getHappyString(int n, int k) {
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1] * 2;
        }

        if (k > 3 * pow[n - 1]) {
            return "";
        }
        k--;

        char[][] next = new char[][] {
            {'b', 'c'}, {'a', 'c'}, {'a', 'b'}
        };

        char[] arr = new char[n];
        arr[0] = (char) ('a' + k / pow[n - 1]);
        k %= pow[n - 1];

        for (int i = 1; i < n; i++) {
            arr[i] = next[arr[i - 1] - 'a'][k / pow[n - 1 - i]];
            k %= pow[n - 1 - i];
        }

        return String.valueOf(arr);
    }
}
