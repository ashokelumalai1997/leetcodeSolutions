class Solution {
    public int numIdenticalPairs(int[] nums) {
        //have a hashamap of number to count
        //iterate over hashmap
        //calculate n(n-1)/2 and add it to total
        int total=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==nums[i]){
                    total++;
                }
            }
        }
        return total;
    }
}