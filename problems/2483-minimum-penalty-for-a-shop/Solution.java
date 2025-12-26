class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int yCount = 0, nCount = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                yCount++;
            }
        }

        int result = 0;
        int p = yCount;

        for (int i = 0; i < n; i++) {
            char c = customers.charAt(i);
            
            if (c == 'Y') {
                yCount--;
            } else {
                nCount++;
            }

            if (p > yCount + nCount) {
                result = i + 1;
                p = yCount + nCount;
            }
        }

        return result;
    }
}
