class Solution {
    public int maxUniqueSplit(String s) {
        return recur(0, s, new HashSet<>());
    }

    private int recur(int idx, String s, Set<Integer> set) {
        if (idx == s.length()) {
            return set.size();
        }

        int result = Integer.MIN_VALUE;
        int hash = 0;

        for (int i = idx; i < s.length(); i++) {
            hash = hash * 31 + (s.charAt(i) - 'a' + 1);

            if (!set.contains(hash)) {
                set.add(hash);
                result = Math.max(result, recur(i + 1, s, set));
                set.remove(hash);
            }
        }

        return result;
    }
}
