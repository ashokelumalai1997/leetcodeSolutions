class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProd=new int[nums.length];
        int[] suffixProd=new int[nums.length];
        prefixProd[0]=nums[0];
        suffixProd[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            prefixProd[i]=prefixProd[i-1]*nums[i];
        }
        suffixProd[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suffixProd[i]=suffixProd[i+1]*nums[i];
        }
        int[] result = new int[nums.length];
        result[0]=suffixProd[1];
        result[nums.length-1]=prefixProd[nums.length-2];
        for(int i=1;i<=nums.length-2;i++){
            result[i]=prefixProd[i-1]*suffixProd[i+1];
        }
        return result;
    }
}