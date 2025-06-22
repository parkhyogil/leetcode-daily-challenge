class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();

        String[] result = new String[(n + k - 1) / k];
        char[] group = new char[k];

        for (int i = 0, j = 0; i < result.length; i++) {
            for (int l = 0; l < k; l++) {
                if (j < n) {
                    group[l] = s.charAt(j++);
                } else {
                    group[l] = fill;
                }
            }

            result[i] = String.valueOf(group);
        }

        return result;
    }
}
