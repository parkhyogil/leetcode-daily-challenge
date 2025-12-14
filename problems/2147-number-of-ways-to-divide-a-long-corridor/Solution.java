class Solution {
    public int numberOfWays(String corridor) {
        char[] arr = corridor.toCharArray();
        int n = arr.length - 1;

        int i = 0, seats = 0, plants = 0;

        while (i <= n && seats < 2) {
            if(arr[i++] == 'S') {
                seats++;
            }
        }

        if (seats < 2) {
            return 0;
        }

        seats = 0;

        while (n >= 0 && seats < 2) {
            if (arr[n--] == 'S') {
                seats++;
            }
        }

        if (n < i) {
            return 1;
        }

        long result = 1;

        while (i <= n) {
            while (i <= n && arr[i] == 'P') {
                i++;
                plants++;
            }

            result = result * (plants + 1) % 1_000_000_007;
            seats = plants = 0;

            while (i <= n && seats < 2) {
                if(arr[i++] == 'S') {
                    seats++;
                }
            }
        }

        return seats % 2 != 0 ? 0 : (int) result;
    }
}
