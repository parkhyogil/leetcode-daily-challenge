class Solution {
    private List<Integer> operands;
    private List<Character> operators;

    public List<Integer> diffWaysToCompute(String expression) {
        parseExpression(expression);

        int size = operands.size();

        List<Integer>[][] cache = new ArrayList[size][size];

        return computeRecursively(0, operands.size() - 1, cache);
    }

    private List<Integer> computeRecursively(int begin, int end, List<Integer>[][] cache) {
        if (cache[begin][end] != null) {
            return cache[begin][end];
        }

        List<Integer> result = new ArrayList<>();

        if (begin == end) {
            result.add(operands.get(begin));
            return cache[begin][end] = result;
        }

        for (int i = begin; i < end; i++) {
            for (int leftVal : computeRecursively(begin, i, cache)) {
                for (int rightVal : computeRecursively(i + 1, end, cache)) {
                    result.add(evaluate(leftVal, rightVal, operators.get(i)));
                }
            }
        }

        return cache[begin][end] = result;
    }

    private int evaluate(int a, int b, char operator) {
        if (operator == '+') {
            return a + b;
        }
        if (operator == '-') {
            return a - b;
        }
        return a * b;
    }

    private void parseExpression(String expression) {
        operands = new ArrayList<>();
        operators = new ArrayList<>();

        int num = 0;

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                operands.add(num);
                num = 0;

                operators.add(c);
            }
        }

        operands.add(num);
    }
}
