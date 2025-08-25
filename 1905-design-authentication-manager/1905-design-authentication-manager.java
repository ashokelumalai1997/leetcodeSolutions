class AuthenticationManager {

    static class QEntry {
        String tokenId;
        Integer time;
        public QEntry(String tokenId, int time) {
            this.tokenId = tokenId;
            this.time = time;
        }
    }

    Map<String, Integer> mp;
    ArrayDeque<QEntry> ad;
    int ttl;

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
        this.mp = new HashMap<>();
        this.ad = new ArrayDeque<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        this.mp.put(tokenId, currentTime);
        this.ad.addLast(new QEntry(tokenId, currentTime));
    }
    
    public void renew(String tokenId, int currentTime) {
        // this.mp.remove(tokenId);
        if(!this.mp.containsKey(tokenId) || this.mp.containsKey(tokenId) && this.mp.get(tokenId) + ttl <= currentTime) {
            return;
        }
        this.mp.put(tokenId, currentTime);
        this.ad.addLast(new QEntry(tokenId, currentTime));
        
    }
    
    public int countUnexpiredTokens(int currentTime) {
        // int count = 0;
        int size = ad.size();
        while(!this.ad.isEmpty() && this.ad.peekFirst().time + ttl <= currentTime) {
            String token = this.ad.peekFirst().tokenId;
            if(this.mp.containsKey(token) && this.mp.get(token) + ttl <= currentTime) {
                this.mp.remove(this.ad.peekFirst().tokenId);
            }
            this.ad.removeFirst();
        }
        return mp.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */