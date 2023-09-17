class Solution {
    public int[] twoSum(int[] numsA, int target) {
        int[] arr = new int[2];
        ArrayList<Integer> nums = new ArrayList<>();
        for(int num:numsA){
            nums.add(num);
        }
        for(int i2=0;i2<nums.size();i2++){
            int num = nums.get(i2);
            int i1 = nums.indexOf(target-num);
            if(nums.contains(target-num)&&i1!=i2){
                arr[0]=Integer.valueOf(i1);
                arr[1]=Integer.valueOf(i2);
                break;
            }
        }
        return arr;
    }
}