class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int result = 0;

        char prev = '*';
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != prev) {
                prev = arr[i];
                len = 0;
            }
            len++;

            result = Math.max(result, len);
        }

        result = Math.max(result, find(n, arr));

        result = Math.max(result, find(n, arr, 'a', 'b'));
        result = Math.max(result, find(n, arr, 'a', 'c'));
        result = Math.max(result, find(n, arr, 'b', 'c'));

        return result;
    }

    int find(int n, char[] arr, char x, char y) {
        int max = 0;

        int begin = -1;
        int c0 = 0, c1 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            char c = arr[i];

            if (!(c == x || c == y)) {
                c0 = c1 = 0;
                begin = i;
                map.put(0, i);
                continue;
            }

            if (c == x) {
                c0++;
            } else {
                c1++;
            }

            int l = map.getOrDefault(c0 - c1, -2);

            if (l >= begin) {
                max = Math.max(max, i - l);
            } else {
                map.put(c0 - c1, i);
            }
        }

        return max;
    }

    int find(int n, char[] arr) {
        int max = 0;
        int c0 = 0, c1 = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("0,0", -1);

        for (int i = 0; i < n; i++) {
            char c = arr[i];

            if (c == 'b') {
                c0++;
            } else if (c == 'c') {
                c1++;
            } else {
                c0--;
                c1--;
            }

            String k = c0 + "," + c1;
            
            if (map.containsKey(k)) {
                max = Math.max(max, i - map.get(k));
            } else {
                map.put(k, i);
            }
        }

        return max;
    }
}
