class Solution {
    private int n, idx;
    private String formula;

    public String countOfAtoms(String formula) {
        idx = 0;
        this.n = formula.length();
        this.formula = formula;

        Map<String, Integer> countOf = recur();

        List<String> sortedAtom = new ArrayList<>(countOf.keySet());
        Collections.sort(sortedAtom);

        StringBuilder sb = new StringBuilder();

        for (String atom : sortedAtom) {
            sb.append(atom);
            if (countOf.get(atom) > 1) {
                sb.append(countOf.get(atom));
            }
        }

        return sb.toString();
    }

    private Map<String, Integer> recur() {
        Map<String, Integer> res = new HashMap<>();

        while (idx < n) {
            char c = formula.charAt(idx++);

            if (c == ')') {
                break;
            } else if (c == '(') {
                Map<String, Integer> inner = recur();
                int count = getCount();

                for (String key : inner.keySet()) {
                    res.put(key, inner.get(key) * count + res.getOrDefault(key, 0));
                }
            } else if (Character.isUpperCase(c)) {
                String atom = getAtom(c);
                int count = getCount();

                res.put(atom, count + res.getOrDefault(atom, 0));
            }
        }

        return res;
    }

    private String getAtom(char c) {
        String res = String.valueOf(c);

        while (idx < n && Character.isLowerCase(formula.charAt(idx))) {
            res += formula.charAt(idx);
            idx++;
        }

        return res;
    }

    private int getCount() {
        if (idx == n || !Character.isDigit(formula.charAt(idx))) {
            return 1;
        }

        int res = 0;

        while (idx < n && Character.isDigit(formula.charAt(idx))) {
            res = res * 10 + (formula.charAt(idx) - '0');
            idx++;
        }

        return res;
    }
}
