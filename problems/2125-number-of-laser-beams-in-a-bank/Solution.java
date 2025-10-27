class Solution {
    public int numberOfBeams(String[] bank) {
        int result = 0;

        int prev = 0;
        for (String s : bank) {
            int count = 0;

            for (char c : s.toCharArray()) {
                count += c - '0';
            }

            result += prev * count;
            if (count > 0) {
                prev = count;
            }
        }

        return result;
    }
}
