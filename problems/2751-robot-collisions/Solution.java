class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        Arrays.sort(arr, (a, b) -> positions[a] - positions[b]);

        int idx = -1;

        for (int i = 0; i < n; i++) {
            while (idx > -1 && directions.charAt(arr[idx]) == 'R' && directions.charAt(arr[i]) == 'L' && healths[arr[i]] > 0) {
                int d = healths[arr[idx]] - healths[arr[i]];
                if (d == 0) {
                    healths[arr[idx]] = healths[arr[i]] = 0;
                    idx--;
                } else if (d > 0) {
                    healths[arr[idx]]--;
                    healths[arr[i]] = 0;
                } else {
                    healths[arr[idx]] = 0;
                    healths[arr[i]]--;
                    idx--;
                }
            }

            if (healths[arr[i]] > 0) {
                arr[++idx] = arr[i];
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }

        return result;
    }
}
