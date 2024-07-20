class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            result.add(new ArrayList<>());
            for(int j = 0; j < colsum.length; j++) {
                result.get(i).add(0);
                
            }
        }
        for(int j = 0; j < colsum.length; j++) {
            if(colsum[j] == 2) {
                result.get(0).set(j, 1);
                result.get(1).set(j, 1);
                lower--;
                upper--;
            }
            
        }
        for(int j = 0; j < colsum.length; j++) {
            if(colsum[j] == 1) {
                System.out.println(upper +" "+ lower);
                if(lower > 0) {
                    lower--;
                    result.get(1).set(j, 1);
                } else {
                    upper--;
                    result.get(0).set(j, 1);
                }
            }
        }
        if(lower !=0 || upper != 0) return new ArrayList<>();
        return result;
    }
}