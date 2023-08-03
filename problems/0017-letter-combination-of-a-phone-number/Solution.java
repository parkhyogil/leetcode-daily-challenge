class Solution {
    private char[][] letters = new char[][] {
        {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
        {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        recur(0, new char[digits.length()], digits, res);

        return res;
    }

    private void recur(int idx, char[] comb, String digits, List<String> res) {
        if (idx == comb.length) {
            res.add(String.valueOf(comb));
            return;
        }

        for (char letter : letters[digits.charAt(idx) - '0' - 1]) {
            comb[idx] = letter;
            recur(idx + 1, comb, digits, res);
        }
    }
}
