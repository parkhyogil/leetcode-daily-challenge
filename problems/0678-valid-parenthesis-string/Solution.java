class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();

        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                open.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!open.isEmpty()) {
            int openIdx = open.pop();

            if (star.isEmpty() || star.peek() < openIdx) {
                return false;
            }

            star.pop();
        }

        return true;
    }
}
