class Solution {
    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        int n = reqSkills.length;
        int m = people.size();

        Map<String, Integer> skillId = new HashMap<>();
        for (int i = 0; i < reqSkills.length; i++) {
            skillId.put(reqSkills[i], i);
        }

        int[] skillMask = new int[m];
        for (int i = 0; i < m; i++) {
            for (String skill : people.get(i)) {
                skillMask[i] |= 1 << skillId.get(skill);
            }
        }

        boolean[] banned = new boolean[m];
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int bit = skillMask[i] | skillMask[j];
                if (bit == skillMask[i]) {
                    banned[j] = true;
                } else if (bit == skillMask[j]) {
                    banned[i] = true;
                }
            }
        }

        long[] memo = new long[1 << n];
        Arrays.fill(memo, -1);

        long resultMask = recur(0, skillMask, memo, banned);

        int[] res = new int[Long.bitCount(resultMask)];
        for (int i = 0, j = 0; i < m; i++) {
            if (((1L << i) & resultMask) != 0) {
                res[j++] = i;
            }
        }
        return res;
    }

    private long recur(int currMask, int[] skillMask, long[] memo, boolean[] banned) {
        if (currMask == memo.length - 1) {
            return 0;
        }
        if (memo[currMask] != -1) {
            return memo[currMask];
        }
        
        for (int i = 0; i < skillMask.length; i++) {
            if (banned[i] || (currMask & skillMask[i]) == skillMask[i]) {
                continue;
            }
            long addedMask = recur(currMask | skillMask[i], skillMask, memo, banned) | (1L << i);
            if (memo[currMask] == -1 || Long.bitCount(addedMask) < Long.bitCount(memo[currMask])) {
                memo[currMask] = addedMask;
            }
        }
        return memo[currMask];
    }
}
