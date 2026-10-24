class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aam = Integer.parseInt(arriveAlice.substring(0, 2));
        int aad = Integer.parseInt(arriveAlice.substring(3, 5));
        int alm = Integer.parseInt(leaveAlice.substring(0, 2));
        int ald = Integer.parseInt(leaveAlice.substring(3, 5));

        int bam = Integer.parseInt(arriveBob.substring(0, 2));
        int bad = Integer.parseInt(arriveBob.substring(3, 5));
        int blm = Integer.parseInt(leaveBob.substring(0, 2));
        int bld = Integer.parseInt(leaveBob.substring(3, 5));

        if (alm < bam || blm < aam) {
            return 0;
        }

        int[] a = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < a.length; i++) {
            a[i] += a[i - 1];
        }

        int al = a[aam - 1] + aad - 1;
        int ar = a[alm - 1] + ald - 1;

        int bl = a[bam - 1] + bad - 1;
        int br = a[blm - 1] + bld - 1;

        return Math.max(0, Math.min(ar, br) - Math.max(al, bl) + 1);
    }
}
