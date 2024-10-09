class Solution {
    public int minAddToMakeValid(String s) {
        int numOfAdds = 0;
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;

                if (balance < 0) {
                    numOfAdds++;
                    balance = 0;
                }
            }
        }

        return numOfAdds + balance;
    }
}
