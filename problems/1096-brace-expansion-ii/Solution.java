class Solution {
    String s;
    int i, j;
    char[] arr;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        i = 0;
        j = -1;
        arr = new char[s.length()];

        List<String> result = recur();

        result.sort(String::compareTo);

        return result;
    }

    List<String> recur() {
        Set<String> result = new HashSet<>();
        Set<String> tmp = new HashSet<>();

        while (i < s.length()) {
            char c = s.charAt(i++);

            if (c == '}') {
                break;
            }

            if (Character.isLetter(c)) {
                arr[++j] = c;
                continue;
            }

            if (j > -1) {
                String s2 = String.valueOf(arr, 0, j + 1);
                j = -1;
                if (tmp.isEmpty()) {
                    tmp.add(s2);
                } else {
                    HashSet<String> next = new HashSet<>();
                    for (String s1 : tmp) {
                        next.add(s1 + s2);
                    }
                    tmp = next;
                }
            }

            if (c == '{') {
                List<String> sub = recur();

                if (tmp.isEmpty()) {
                    tmp.addAll(sub);
                } else {
                    HashSet<String> next = new HashSet<>();
                    for (String s1 : tmp) {
                        for (String s2 : sub) {
                            next.add(s1 + s2);
                        }
                    }
                    tmp = next;
                }
            } else {
                result.addAll(tmp);
                tmp.clear();
            }
        }

        if (j > -1) {
            String s2 = String.valueOf(arr, 0, j + 1);
            j = -1;
            if (tmp.isEmpty()) {
                tmp.add(s2);
            } else {
                HashSet<String> next = new HashSet<>();
                for (String s1 : tmp) {
                    next.add(s1 + s2);
                }
                tmp = next;
            }
        }

        if (!tmp.isEmpty()) {
            result.addAll(tmp);
        }

        return new ArrayList<>(result);
    }
}
