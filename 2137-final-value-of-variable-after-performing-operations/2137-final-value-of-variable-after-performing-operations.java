class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String op:operations){
            if(op.equals("X++")||op.equals("++X")){
                x+=1;
            } else {
                x-=1;
            }
        }
        return x;
    }
}