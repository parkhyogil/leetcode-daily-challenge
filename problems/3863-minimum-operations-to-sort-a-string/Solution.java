class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        if (n == 2 && arr[0] > arr[1]) {
            return -1;
        }

        char min = 'z';
        int minF = 0;
        char max = 'a';
        int maxF = 0;
        boolean sorted = true;
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c < min) {
                min = c;
                minF = 1;
            } else if (c == min) {
                minF++;
            }
            
            if (c > max) {
                max = c;
                maxF = 1;
            } else if (c == max) {
                maxF++;
            }

            if (i > 0 && arr[i - 1] > arr[i]) {
                sorted = false;
            }
        }

        if (sorted) {
            return 0;
        }

        if (arr[0] == min || arr[n - 1] == max) {
            return 1;
        }

        if (arr[0] == max && arr[n - 1] == min && minF == 1 && maxF == 1) {
            
            return 3;
        }
        
        return 2;
    }    
}
