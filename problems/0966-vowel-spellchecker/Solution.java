class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int m = wordlist.length;
        int n = queries.length;

        Set<String> first = new HashSet<>();
        Map<String, String> second = new HashMap<>();
        Map<String, String> thrid = new HashMap<>();

        for (int i = m - 1; i >= 0; i--) {
            String s = wordlist[i];
            String c = s.toLowerCase();

            first.add(s);
            second.put(c, s);
            thrid.put(toIgnoreVowels(c), s);
        }

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String s = queries[i];
            String c = s.toLowerCase();

            if (first.contains(s)) {
                result[i] = s;
            } else if (second.containsKey(c)) {
                result[i] = second.get(c);
            } else if (thrid.containsKey(toIgnoreVowels(c))) {
                result[i] = thrid.get(toIgnoreVowels(c));
            } else {
                result[i] = "";
            }
        }

        return result;
    }

    String toIgnoreVowels(String s) {
        char[] a = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i);

            if (a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o' || a[i] == 'u') {
                a[i] = '*';
            }
        }

        return String.valueOf(a);
    }
}
