class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();

        List<List<String>> palindromeList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            palindromeList.add(new ArrayList<>());
        }
        for (int start = 0; start < len; start++) {
            for (int end = start; end < len; end++) {
                if (isPalindrome(s, start, end)) {
                    palindromeList.get(start).add(s.substring(start, end + 1));
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), res, palindromeList);
        return res;
    }

    private void backtrack(int start, List<String> partition, List<List<String>> res, List<List<String>> palindromeList) {
        if (start == palindromeList.size()) {
            res.add(new ArrayList<>(partition));
            return;
        }

        for (String pal : palindromeList.get(start)) {
            partition.add(pal);
            backtrack(start + pal.length(), partition, res, palindromeList);
            partition.remove(partition.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
