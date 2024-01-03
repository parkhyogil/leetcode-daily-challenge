class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int res = 0;

        for (String row : bank) {
            int numberOfDevice = countDevice(row);

            if (numberOfDevice > 0) {
                res += prev * numberOfDevice;
                prev = numberOfDevice;
            }
        }

        return res;
    }

    private int countDevice(String row) {
        int res = 0;

        for (char c : row.toCharArray()) {
            if (c == '1') {
                res++;
            }
        }
        
        return res;
    }
}
