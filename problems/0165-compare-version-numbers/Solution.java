class Solution {
    public int compareVersion(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();

        int i = 0;
        int j = 0;

        while (i < m || j < n) {
            int v1 = 0;
            while (i < m && version1.charAt(i) != '.') {
                v1 = v1 * 10 + (version1.charAt(i) - '0');
                i++;
            }   
            i++;

            int v2 = 0;
            while (j < n && version2.charAt(j) != '.') {
                v2 = v2 * 10 + (version2.charAt(j) - '0');
                j++;
            }   
            j++;

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }

        return 0;
    }
}
