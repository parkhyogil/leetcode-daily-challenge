class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        int n = s.length();

        int zigLen = (numRows - 1) * 2;

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int i = 0; i + row < n; i += zigLen) {
                sb.append(s.charAt(row + i));
                if (row > 0 && row < numRows - 1 && i + zigLen - row < n) {
                    sb.append(s.charAt(i + zigLen - row));
                }
            }
        }
        return sb.toString();
    }
}
