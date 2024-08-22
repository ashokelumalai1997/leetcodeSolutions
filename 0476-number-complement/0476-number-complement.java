class Solution {
    public int findComplement(int num) {
        int result = 0;
        int mover = 0;
        int temp = num;
        while(temp != 0) {
            temp = temp >> 1;
            mover++;
        }
        mover--;
        while(mover >= 0) {
            if((num & (1<<mover)) == 0) { result = result + (1 << mover); }
            
            mover--;
        }
        return result;
    }
}