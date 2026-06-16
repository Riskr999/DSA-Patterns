class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack= new ArrayDeque<>();

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack= new ArrayDeque<>();
        

    }
    
    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty()){
            minStack.push(value);
        }
        else{
            int currentmin = Math.min(minStack.peek(), value);
            minStack.push(currentmin);

        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        
        return minStack.peek();
    }
}
