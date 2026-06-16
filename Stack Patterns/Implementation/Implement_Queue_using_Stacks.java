class MyQueue {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());

        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    
    public int pop() {
        return stack1.pop();
        
    }
    
    public int peek() {
        return stack1.peek();
        
    }
    
    public boolean empty() {
        return stack1.isEmpty();
        
    }
}
