class MinStack {
    Stack<Integer> s, minStack;

    public MinStack() {
        s = new Stack();
        minStack = new Stack();
    }
    
    public void push(int val) {
        s.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (s.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
