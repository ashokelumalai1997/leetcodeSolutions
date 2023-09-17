class Solution {
    public List<String> cellsInRange(String s) {
        List<String> out=new ArrayList<>();
        String[] limit = s.split(":");
        char startChar = limit[0].charAt(0);
        char endChar = limit[1].charAt(0);
        char startInt = s.charAt(1);
        char endInt = s.charAt(4);
        //int startInt = Integer.parseInt(String.valueOf(limit[0].charAt(1)));
        //int endInt = Integer.parseInt(String.valueOf(limit[1].charAt(1)));
        for(char t=startChar;t<=endChar;t++){
            System.out.println(t);
            for(char u=startInt;u<=endInt;u++){
                //System.out.println("a");
                String temp = t+String.valueOf(u);
                out.add(temp);
            }
        }
        return out;
    }
}