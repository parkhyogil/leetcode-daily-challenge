class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();

        int alice = 0;
        
        for (int i = 1; i < n - 1; i++) {
            char prev = colors.charAt(i - 1);
            char curr = colors.charAt(i);
            char next = colors.charAt(i + 1);

            if (prev == curr && curr == next) {
                alice += curr == 'A' ? 1 : -1;
            }
        }

        return alice > 0;
    }
}
