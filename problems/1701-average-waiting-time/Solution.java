class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;

        int currTime = 0;
        long waitingTime = 0;

        for (int[] customer : customers) {
            currTime = Math.max(currTime, customer[0]) + customer[1];

            waitingTime += currTime - customer[0];
        }

        return 1.0 * waitingTime / n;
    }
}
