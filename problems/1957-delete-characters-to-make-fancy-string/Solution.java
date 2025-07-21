class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        char prev = '*';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c != prev) {
                prev = c;
                count = 0;
            }

            count++;

            if (count < 3) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
