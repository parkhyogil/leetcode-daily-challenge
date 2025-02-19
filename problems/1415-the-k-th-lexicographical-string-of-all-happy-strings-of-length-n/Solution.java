class Solution {
    public String getHappyString(int n, int k) {
        if (k > (1 << (n - 1)) * 3) {
            return "";
        }
        k--;

        int[] arr = new int[n];

        for (int i = n - 1; i > 0; i--) {
            arr[i] = k % 2;
            k /= 2;
        }
        arr[0] = k % 3;

        char[] chars = new char[n];
        chars[0] = (char) ('a' + arr[0]);
        
        for (int i = 1; i < n; i++) {
            chars[i] = getNextLetter(chars[i - 1], arr[i]);
        }

        return String.valueOf(chars);
    }

    char getNextLetter(char prev, int k) {
        if (prev == 'a') {
            return k == 0 ? 'b' : 'c';
        } else if (prev == 'b') {
            return k == 0 ? 'a' : 'c';
        } else {
            return k == 0 ? 'a' : 'b';
        }
    }
}
