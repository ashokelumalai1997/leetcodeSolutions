class Solution {
    public List<String> buildArray(int[] target, int n) {
        // Have an init = 0
        // iterate over target
        // if current-init>1 {
            // while(current-init-1){
                //push(Push)
            //}
            // same amount of pop
            // push
        //}
        //else push
        //
        int init = 0;
        List<String> result = new ArrayList<>();
        for(int i=0;i<target.length;i++){
            if(target[i]-init>1){
                int count = target[i]-init-1;
                int count1 = count;
                while(count1>0){
                    count1--;
                    result.add("Push");
                }
                while(count>0){
                    count--;
                    result.add("Pop");
                }
                
            }
            init =target[i];
            result.add("Push");
        }
        return result;
    }
}