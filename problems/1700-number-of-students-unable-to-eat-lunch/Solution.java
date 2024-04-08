class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circular = 0;
        int square = 0;

        for (int student : students) {
            if (student == 0) {
                circular++;
            } else {
                square++;
            }
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && circular > 0) {
                circular--;
            } else if (sandwich == 1 && square > 0) {
                square--;
            } else {
                return circular + square;
            }
        }

        return 0;
    }
}
