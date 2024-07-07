class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        int ind = 1;
        result.add("0");
        result.add("1");
        String currentString = null;
        // System.out.println(result.size());
        while(ind < n) {
            // System.out.println(result.size());
            int cs = result.size();
            for(int i = 0; i < cs;i++) {
                // System.out.println(result.size());
                currentString = result.get(i);
                if(currentString.charAt(ind - 1) == '1') {
                    result.set(i, currentString + "0");
                    result.add(currentString + "1");
                } else {
                    result.set(i, currentString + "1");
                }
            }
            ind++;
        }
        return result;
    }
}
