class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;

        for (int i = 0; i <= n / 2; i++) {
            int l = (startIndex - i + n) % n;
            int r = (startIndex + i) % n;

            if (words[l].equals(target) || words[r].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
