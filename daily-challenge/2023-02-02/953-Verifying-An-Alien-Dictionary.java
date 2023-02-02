class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;

        int[] orders = new int[26];
        for (int i = 0; i < 26; i++) {
            orders[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            if (compare(words[i], words[i + 1], orders) == 1) {
                return false;
            }
        }

        return true;
    }

    private int compare(String s1, String s2, int[] orders) {
        int m = s1.length();
        int n = s2.length();

        for (int i = 0; i < Math.min(m, n); i++) {
            int o1 = orders[s1.charAt(i) - 'a'];
            int o2 = orders[s2.charAt(i) - 'a'];

            if (o1 < o2) {
                return -1;
            } else if (o1 > o2) {
                return 1;
            }
        }

        return m == n ? 0 : (m < n ? -1 : 1);
    }
}
