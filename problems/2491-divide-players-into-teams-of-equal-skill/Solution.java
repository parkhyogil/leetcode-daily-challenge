class Solution {
    public long dividePlayers(int[] skills) {
        int[] skillFrequency = new int[1001];
        int minSkill = Integer.MAX_VALUE;
        int maxSkill = Integer.MIN_VALUE;

        for (int skill : skills) {
            skillFrequency[skill]++;
            minSkill = Math.min(minSkill, skill);
            maxSkill = Math.max(maxSkill, skill);
        }

        long chemistrySum = 0L;

        while (minSkill < maxSkill) {
            if (skillFrequency[minSkill] != skillFrequency[maxSkill]) {
                return -1;
            }

            chemistrySum += (long) minSkill * maxSkill * skillFrequency[minSkill];

            minSkill++;
            maxSkill--;
        }

        if (minSkill == maxSkill) {
            if (skillFrequency[minSkill] % 2 == 1) {
                return -1;
            }
            chemistrySum += (long) minSkill * maxSkill * skillFrequency[minSkill] / 2;
        }

        return chemistrySum;
    }
}
