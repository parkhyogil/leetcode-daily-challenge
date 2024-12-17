class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] frequency = countFrequency(s);
        System.out.println(Arrays.toString(frequency));
        StringBuilder sb = new StringBuilder();

        for (int i = 25; i >= 0; i--) {
            int j = i - 1;
            while (frequency[i] > repeatLimit) {
                appendRepeatedly((char) ('a' + i), sb, repeatLimit);
                frequency[i] -= repeatLimit;

                while (j >= 0 && frequency[j] == 0) {
                    j--;
                }

                if (j == -1) {
                    return sb.toString();
                }

                sb.append((char) ('a' + j));
                frequency[j]--;
            }   

            appendRepeatedly((char) ('a' + i), sb, frequency[i]);
            frequency[i] = 0;
        }

        return sb.toString();
    }

    void appendRepeatedly(char c, StringBuilder sb, int times) {
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
    }

    int[] countFrequency(String s) {
        int[] result = new int[26];

        for (char c : s.toCharArray()) {
            result[c - 'a']++;
        }

        return result;
    }
}
