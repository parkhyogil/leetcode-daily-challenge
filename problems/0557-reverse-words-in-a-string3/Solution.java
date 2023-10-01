class Solution {
    public String reverseWords(String s) {
        int n = s.length();

        char[] arr = s.toCharArray();

        for (int l = 0; l < n; ) {
            int r = l;

            while (r < n && arr[r] != ' ') {
                r++;
            }

            reverse(arr, l, r - 1);
            l = r + 1;
        }

        return String.valueOf(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
}
