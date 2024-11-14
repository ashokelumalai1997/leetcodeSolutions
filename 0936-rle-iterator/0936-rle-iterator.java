class RLEIterator {

    int[] enc;

    int pointer;

    public RLEIterator(int[] encoding) {
        this.enc = encoding;
        this.pointer = 0;
    }
    
    public int next(int n) {
        while(pointer < enc.length && enc[pointer] < n) {
            n -= enc[pointer];
            pointer += 2;
        }
        
        if(pointer > enc.length-1) return -1;
        
        int ele = enc[pointer+1];
        enc[pointer] -= n;
        return ele;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */