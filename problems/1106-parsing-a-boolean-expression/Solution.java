class Solution {
    public boolean parseBoolExpr(String expression) {
        return parseRecursively(new int[] {0}, expression);
    }

    private boolean parseRecursively(int[] idx, String expression) {
        char c = expression.charAt(idx[0]++);

        if (c == 't') {
            return true;
        }
        if (c == 'f') {
            return false;
        }

        boolean containTrue = false;
        boolean containFalse = false;

        idx[0]++;
        while (expression.charAt(idx[0]) != ')') {
            if (expression.charAt(idx[0]) == ',') {
                idx[0]++;
            } else if (parseRecursively(idx, expression)){
                containTrue = true;
            } else {
                containFalse = true;
            }
        }
        idx[0]++;

        if (c == '&') {
            return !containFalse;
        } else if (c == '|') {
            return containTrue;
        } else {
            return containFalse;
        }
    }
}
