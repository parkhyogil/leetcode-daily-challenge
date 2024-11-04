class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        char prevChar = word.charAt(0);

        for (char c : word.toCharArray()) {
            if (c == prevChar) {
                if (num == 9) {
                    sb.append(num).append(prevChar);
                    num = 0;
                }

                num++; 
            } else {
                sb.append(num).append(prevChar);

                num = 1;
                prevChar = c;
            }
        }

        sb.append(num).append(prevChar);

        return sb.toString();
    }
}
