class Solution {
    public int minSwaps(String s) {
        int n = s.length();

        int balance = 0;
        int numSwaps = 0;

        for (int i = 0, j = n - 1; i < j; i++) {
            if (s.charAt(i) == '[') {
                balance++;
            } else {
                balance--;
                
                if (balance == -1) {
                    while (s.charAt(j) == ']') {
                        j--;
                    }
                    numSwaps++;
                    balance = 1;
                    j--;
                }
            }
        }

        return numSwaps;
    }
}
