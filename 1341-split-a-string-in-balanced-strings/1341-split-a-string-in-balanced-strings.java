class Solution {
    public int balancedStringSplit(String s) {
        int rCount=0,lCount=0,count=0;
        for(char c:s.toCharArray()){
            if(c=='L') lCount+=1;
            if(c=='R') rCount+=1;
            if(lCount==rCount) {
                count+=1;
                lCount=0;
                rCount=0;
            }
        }
        return count;
    }
}