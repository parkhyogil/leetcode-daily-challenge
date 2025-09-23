class Solution {
    public int compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();

        int i = 0;
        int j = 0;

        while (i < n || j < m) {
            int v1 = 0;
            int v2 = 0;

            while (i < n && version1.charAt(i) != '.') {
                v1 = v1 * 10 + version1.charAt(i++) - '0';
            }
            i++;

            while (j < m && version2.charAt(j) != '.') {
                v2 = v2 * 10 + version2.charAt(j++) - '0';
            }
            j++;

            if (v1 < v2) {
                return -1;
            }
            if (v1 > v2) {
                return 1;
            }
        }

        return 0;
    }
}
