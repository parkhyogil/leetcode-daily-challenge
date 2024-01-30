class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" :
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-" :
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*" :
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/" :
                    stack.push((int) (1.0 / stack.pop() * stack.pop()));
                    break;
                default :
                    stack.push(Integer.parseInt(token));
            }
        }
      
        return stack.pop();
    }
}
