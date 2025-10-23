class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                arr[j] = (arr[j] + arr[j + 1]) % 10;
            }
        }

        return arr[0] == arr[1];
    }
}
