class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;

        int[] result = new int[n];

        if (k == 0) {
            return result;
        }

        int sum = 0;

        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }    

            for (int i = 0; i < n; i++) {
                result[i] = sum;
                sum = sum + code[(i + 1 + k) % n] - code[(i + 1) % n];
            }
        } else {
            k *= -1;
            
            for (int i = 1; i <= k; i++) {
                sum += code[n - 1 - i];
            }

            for (int i = n - 1; i >= 0; i--) {
                result[i] = sum;
                System.out.println(sum);
                sum = sum + code[(n + i - 1 - k) % n] - code[(n + i - 1) % n];
            }
        }

        return result;
    }
}
