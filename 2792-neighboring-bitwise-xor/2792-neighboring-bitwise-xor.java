class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;

        for(int d : derived) xor ^= d;
        return xor == 0;
    }
}