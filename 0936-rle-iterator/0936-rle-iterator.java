class RLEIterator {

    int[] enc;

    int pointer;

    public RLEIterator(int[] encoding) {
        this.enc = encoding;
        this.pointer = 0;
    }
    
    public int next(int n) {
        if(pointer > enc.length-1) return -1;
        if(enc[pointer] >= n) {
            int ele = enc[pointer+1];
            enc[pointer] -= n;
            return ele;
        }
        n -= enc[pointer];
        pointer += 2;
        return next(n);
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */