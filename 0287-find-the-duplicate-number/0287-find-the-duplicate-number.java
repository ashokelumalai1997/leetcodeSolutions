class Solution {
    public int findDuplicate(int[] nums) {
        var map = new HashMap<Integer,Integer>();
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int res=0;
        for(var e: map.entrySet()){
            if(e.getValue()>1) res = e.getKey();
        }
        return res;
    }
}