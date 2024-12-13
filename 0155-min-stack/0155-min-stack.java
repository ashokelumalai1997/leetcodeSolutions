class MinStack {

    static class Entity {
        int val;
        int min;
        public Entity(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }


    Stack<Entity> st;

    public MinStack() {
        this.st = new Stack<>();
    }
    
    public void push(int val) {
        int min = Integer.MAX_VALUE;
        if(!st.isEmpty()) {
            min = st.peek().min;
        }
        st.push(new Entity(val, Math.min(val, min)));
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */