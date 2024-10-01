class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : arr) {
            int currentMod = (num%k + k)%k;
            int neededMod = 0;
            if(currentMod != 0) {
                neededMod = k - currentMod;
            }
            if(hm.containsKey(neededMod)) {
                hm.put(neededMod, hm.get(neededMod)-1);
                if(hm.get(neededMod) == 0) hm.remove(neededMod);
            } else {
                hm.putIfAbsent(currentMod, 0);
                hm.put(currentMod, hm.get(currentMod) + 1);
            }
        }
        return hm.size() == 0;
    }
}