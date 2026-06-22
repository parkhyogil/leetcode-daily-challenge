class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[128];

        for (char c : text.toCharArray()) {
            freq[c]++;
        }

        return Math.min(freq['a'], Math.min(freq['b'], Math.min(freq['l'] / 2, Math.min(freq['o'] / 2, freq['n']))));
    }
}
