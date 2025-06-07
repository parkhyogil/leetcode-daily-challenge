class Solution {
    public String clearStars(String s) {
        int n = s.length();

        Deque<Integer>[] deques = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            deques[i] = new ArrayDeque<>();
        }
        boolean[] removed = new boolean[n];

        int minChar = 'z';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '*') {
                while (deques[minChar - 'a'].size() == 0) {
                    minChar++;
                }
                removed[deques[minChar - 'a'].pop()] = true;
            } else {
                minChar = Math.min(minChar, c);
                deques[c - 'a'].push(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '*' && !removed[i]) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
