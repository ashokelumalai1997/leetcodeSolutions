class Solution {
    public int getWinner(int[] arr, int k) {
        int result = arr[0];
        int count = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<result)count++;
            else {
                count=1;
                result=arr[i];
            }
            if(count==k) return result;
        }
        return result;
    }
}