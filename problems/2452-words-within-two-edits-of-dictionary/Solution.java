class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries[0].length();

        List<String> result = new ArrayList<>();

        for (String s : queries) {
            for (String t : dictionary) {
                if (match(n, s, t)) {
                    result.add(s);
                    break;
                }
            }
        }

        return result;
    }

    boolean match(int n, String s, String t) {
        int diff = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }

        return true;
    }
}
