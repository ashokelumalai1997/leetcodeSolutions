class Solution {
    public int numIdenticalPairs(int[] nums) {
        //have a hashamap of number to count
        //iterate over hashmap
        //calculate n(n-1)/2 and add it to total
        HashMap<Integer,Integer> numToCount = new HashMap<>();
        int total=0;
        for(int num:nums){
            numToCount.put(num,numToCount.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : numToCount.entrySet()){
            int current = entry.getValue();
            total+=current*(current-1)/2;
        }
        return total;
    }
}