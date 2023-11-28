class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int numberOfWays(String corridor) {
        int seats = 0;
        int plants = 0;

        long res = 1;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                if (seats % 2 == 0) {
                    res = res * (plants + 1) % MOD;
                    plants = 0;
                }
                seats++;
            } else if (seats > 0 && seats % 2 == 0){
                plants++;
            }
        }

        return seats == 0 || seats % 2 == 1 ? 0 : (int) (res % MOD);
    }
}
