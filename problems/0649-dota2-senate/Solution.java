class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        int radiantCount = 0;
        int direCount = 0;

        for (char c : senate.toCharArray()) {
            q.offer(c);
            if (c == 'R') {
                radiantCount++;
            } else {
                direCount++;
            }
        }

        int r = 0;
        int d = 0;
        while (radiantCount > 0 && direCount > 0) {
            char c = q.poll();
            if (c == 'R') {
                if (d == 0) {
                    q.offer(c);
                    r++;
                } else {
                    d--;
                    radiantCount--;
                }
            } else {
                if (r == 0) {
                    q.offer(c);
                    d++;
                } else {
                    r--;
                    direCount--;
                }
            }
        }
        return radiantCount > 0 ? "Radiant" : "Dire";
    }
}
