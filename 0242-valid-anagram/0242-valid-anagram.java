class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
                continue;
            }
            map.put(c,1);
        }
        for(char c:t.toCharArray()){
            if(map.containsKey(c)&&map.get(c)>0){
                int temp=map.get(c)-1;
                map.put(c,temp);
                if(temp==0) map.remove(c);
                continue;
            }
            return false;
        }
        if(map.isEmpty()) return true;
        return false;
    }
}