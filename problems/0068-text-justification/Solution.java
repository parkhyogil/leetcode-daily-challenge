class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;

        List<String> res = new ArrayList<>();

        int l = 0;
        while (l < n) {
            int r = l + 1;
            int length = words[l].length();

            while (r < n && (length + words[r].length() + r - l) <= maxWidth) {
                length += words[r].length();
                r++;
            }

            int space = maxWidth - length;

            StringBuilder sb = new StringBuilder();

            if (r == n) {
                for (int i = l; i < r - 1; i++) {
                    sb.append(words[i]).append(' ');
                }
            } else {
                for (int i = l; i < r - 1; i++) {
                    sb.append(words[i]).append(" ".repeat(space / (r - l - 1)));
                    if (i - l < space % (r - l - 1)) {
                        sb.append(' ');
                    }
                }
            }
            
            sb.append(words[r - 1]);
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }

            res.add(sb.toString());
            l = r;
        }

        return res;
    }
}
