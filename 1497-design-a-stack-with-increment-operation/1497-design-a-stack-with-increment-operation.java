class CustomStack {

    Stack<Integer> st;

    int size;

    int[] incTracker;

    public CustomStack(int maxSize) {
        st = new Stack<>();
        this.size = maxSize;
        this.incTracker = new int[maxSize];
    }
    
    public void push(int x) {
        if(st.size() == size) return;

        st.push(x);
    }
    
    public int pop() {
        if(st.size() == 0) return -1;
        int pos = st.size()-1;
        int ele = st.pop();
        ele += incTracker[pos];
        if(pos - 1 >= 0) {
            incTracker[pos - 1] += incTracker[pos];
        }
        incTracker[pos] = 0;
        return ele;
    }
    
    public void increment(int k, int val) {
        if(k > st.size()) k = st.size();
        if(k == 0) return;
        incTracker[k-1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */