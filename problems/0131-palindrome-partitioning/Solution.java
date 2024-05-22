class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();

        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int left = 0; left + diff < n; left++) {
                isPalindrome[left][left + diff] = s.charAt(left) == s.charAt(left + diff) && isPalindrome[left + 1][left + diff - 1];
            }
        }

        List<List<String>> res = new ArrayList<>();

        recur(0, s, isPalindrome, new ArrayList<>(), res);

        return res;
    }

    private void recur(int idx, String s, boolean[][] isPalindrome, List<String> list, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome[idx][i]) {
                list.add(s.substring(idx, i + 1));
                recur(i + 1, s, isPalindrome, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
