class LUPrefix {

    int waitingFor;

    int n;

    Set<Integer> hs;

    public LUPrefix(int n) {
        hs = new HashSet<>();
        this.n = n;
        this.waitingFor = 1;
    }
    
    public void upload(int video) {
        hs.add(video);
        if(waitingFor == video) {
            while(hs.contains(waitingFor)) waitingFor++;
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