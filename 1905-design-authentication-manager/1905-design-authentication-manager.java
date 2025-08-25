class AuthenticationManager {

    Map<String, Integer> mp;
    int ttl;

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
        this.mp = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        this.mp.put(tokenId, currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        // this.mp.remove(tokenId);
        if(!this.mp.containsKey(tokenId) || this.mp.containsKey(tokenId) && this.mp.get(tokenId) + ttl <= currentTime) {
            return;
        }
        this.mp.put(tokenId, currentTime);
        
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for(Map.Entry<String, Integer> entry : this.mp.entrySet()) {
            if(entry.getValue() + ttl > currentTime) {
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */