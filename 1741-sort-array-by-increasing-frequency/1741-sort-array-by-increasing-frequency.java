class Solution {
    class Pair implements Comparable<Pair>{
        int num;
        int freq;
        public  Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Pair p){
            if(this.freq != p.freq) return this.freq - p.freq;
            return p.num - this.num;
        }
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        List<Pair> l = new ArrayList<>();
        for(Map.Entry<Integer, Integer> me : numMap.entrySet() ){
            l.add(new Pair(me.getKey(), me.getValue()));
        }
        Collections.sort(l);
        int[] out = new int[nums.length];
        int i = 0;
        for(Pair p : l) {
            for(int j = 0; j < p.freq; j++) {
                out[i] = p.num;
                i++;
            }
        }
        return out;
    }
}