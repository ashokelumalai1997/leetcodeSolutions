class LUPrefix {

    int waitingFor;

    int n;

    // Set<Integer> hs;
    boolean[] hs;

    public LUPrefix(int n) {
        hs = new boolean[n+1];
        this.n = n;
        this.waitingFor = 1;
    }
    
    public void upload(int video) {
        // hs.add(video);
        hs[video] = true;
        if(waitingFor == video) {
            // while(hs.contains(waitingFor)) waitingFor++;
            while(waitingFor < n+1 && hs[waitingFor]) waitingFor++;
        }
    }
    
    public int longest() {
        return waitingFor-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */