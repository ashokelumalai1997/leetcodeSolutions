class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        HashMap<String,Integer> keyCode = new HashMap<>();
        keyCode.put("type",0);
        keyCode.put("color",1);
        keyCode.put("name",2);
        int count=0;
        int key=Integer.valueOf(keyCode.get(ruleKey));
        for(List<String> item:items){
            System.out.println(item.get(key));
            if(item.get(key).equals(ruleValue)) count++;
        }
        return count;
    }
}