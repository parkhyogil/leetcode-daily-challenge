class MyStack {
    private Queue<Integer> q;
    private int topElement;

    public MyStack() {
        q = new LinkedList<>();
        topElement = -1;
    }
    
    public void push(int x) {
        q.offer(x);
        topElement = x;
    }
    
    public int pop() {
        for (int i = 0; i < q.size() - 1; i++) {
            topElement = q.poll();
            q.offer(topElement);
        }        
        return q.poll();
    }
    
    public int top() {
        return topElement;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
