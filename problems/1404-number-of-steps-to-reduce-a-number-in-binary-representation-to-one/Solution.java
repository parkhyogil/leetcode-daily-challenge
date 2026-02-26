class Solution {
    public int numSteps(String s) {
        int result = 0;

        int i = s.length() - 1;
        char[] arr = s.toCharArray();

        while (i >= 0) {
            if (arr[i] == '1') {
                if (i == 0) {
                    break;
                }
                
                int j = i;

                while (j >= 0 && arr[j] == '1') {
                    j--;
                }

                result += i - j + 1;
                if (j >= 0) {
                    arr[j] = '1';
                }
                i = j;
            } else {
                result++;
                i--;
            }
        }

        return result;
    }
}
