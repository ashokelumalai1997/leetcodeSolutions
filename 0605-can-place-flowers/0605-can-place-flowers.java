class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int totalPossible=0;
        //1,0,0,0,0,1
        for(int i=0;i<flowerbed.length;i++){
            boolean isSafe=false;
            boolean isSafe1=false;
            if(i-1<0||flowerbed[i-1]!=1) isSafe=true;
            if(i+1>=flowerbed.length||flowerbed[i+1]!=1) isSafe1=true;
            if(flowerbed[i]!=1&&isSafe&&isSafe1) {
                totalPossible++;
                flowerbed[i]=1;
            }
        }
        if(totalPossible>=n) return true;
        return false;
    }
}