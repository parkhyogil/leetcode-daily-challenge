class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9 && j + i - 1 <= 9; j++) {
                int num = 0;
                for (int k = 0; k < i; k++) {
                    num = num * 10 + j + k;
                }

                if (low <= num && num <= high) {
                    res.add(num);
                }
            }
        }

        return res;
    }
}
