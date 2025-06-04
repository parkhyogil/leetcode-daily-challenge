class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        int n = word.length();

        int maxLength = n - numFriends + 1;

        char maxChar = 'a';
        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (c > maxChar) {
                maxChar = c;
                indexList.clear();
                indexList.add(i);
            } else if (c == maxChar) {
                indexList.add(i);
            }
        }

        int begin = indexList.get(0);
        int end = Math.min(begin + maxLength, n);

        for (int i : indexList) {
            int e = Math.min(i + maxLength, n);
            if (compare(i, e, begin, end, word)) {
                begin = i;
                end = e;
            }
        }

        return word.substring(begin, end);
    }

    private boolean compare(int s1, int e1, int s2, int e2, String s) {
        while (s1 < e1 && s2 < e2) {
            char c1 = s.charAt(s1++);
            char c2 = s.charAt(s2++);

            if (c1 > c2) {
                return true;
            } else if (c1 < c2) {
                return false;
            }
        }

        return s1 < e1;
    }
}
