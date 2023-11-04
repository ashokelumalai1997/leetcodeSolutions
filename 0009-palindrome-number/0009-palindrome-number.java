class Solution {
    public boolean isPalindrome(int x) {
        String strInt = String.valueOf(x);
        int left =0;
        int right = strInt.length()-1;
        while(left<right){
            if(strInt.charAt(left)!=strInt.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}