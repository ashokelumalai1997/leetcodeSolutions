class Solution {
    public int findDuplicate(int[] nums) {
        //var map = new HashMap<Integer,Integer>();
        var map = new int[nums.length];
        for(int num:nums)
        {
            map[num]++;
            //map.put(num,map.getOrDefault(num,0)+1);
        }
        int res=0;
        for(int i=0;i<nums.length;i++) {
            if(map[i]>1) 
            {
                res = i;
            }
        }
        return res;
    }
}