class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;

        for (int i = 0; i < operations.length; i++) {
            String s = operations[i];
            
            if (s.charAt(0) == '+' || s.charAt(2) == '+') {
                result++;
            } else {
                result--;
            }
        }

        return result;
    }
}
