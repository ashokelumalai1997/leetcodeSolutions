class Solution {
    public long dividePlayers(int[] skills) {
        long result = 0;
        int n = skills.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int sum = 0;
        for(int skill : skills) sum += skill;
        if((2*sum)%n != 0) return -1;
        int target = 2*sum/n;
        for(int skill : skills) {
            int req = Math.abs(target - skill);
            if(!freqMap.containsKey(req)) {
                freqMap.putIfAbsent(skill, 0);
                freqMap.put(skill, freqMap.get(skill)+1);
            } else {
                int currentReqFreq = freqMap.get(req);
                if(currentReqFreq == 1) {
                    freqMap.remove(req);
                } else {
                    freqMap.put(req, currentReqFreq-1);
                }
                result += req*skill;
            }
        }
        if(!freqMap.isEmpty()) return -1;
        return result;
    }
}

/*


skill
skill[i]



*/