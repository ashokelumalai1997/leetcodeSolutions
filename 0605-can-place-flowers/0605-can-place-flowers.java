class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeros = 1;
        int res = 0;
        for(int f : flowerbed) {
            if(f != 0) {
                res += (zeros-1)/2;
                zeros = 0;
                continue;
            }
            zeros++;
        }

        res += (zeros)/2;

        return res >= n;
    }
}




// 1   0   1   0   1   0   0   0   0   0   1