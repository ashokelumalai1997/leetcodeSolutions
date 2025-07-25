class Solution {
    
    private List<Double> getOptions(Double a, Double b) {
        List<Double> options = new ArrayList<>();
        
        
        options.add(a + b);
        options.add(a - b);
        options.add(b - a);
        options.add(a*b);
        if(b != 0) options.add(a/b);
        if(a != 0) options.add(b/a);
        
        return options;
    }
    public boolean canMake24(List<Double> input) {
        if(input.size() == 1) {
            return Math.abs(input.get(0) - 24.0) <= 0.01;
        }
        
        int n = input.size();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                
                List<Double> newInput = new ArrayList<>();
                
                for(int k = 0; k < n; k++) {
                    if(k != i && k != j) newInput.add(input.get(k));
                }
                
                List<Double> options = getOptions(input.get(i), input.get(j));
                
                
                for(int k = 0; k < options.size(); k++) {
                    newInput.add(options.get(k));
                    if(canMake24(newInput)) return true;
                    newInput.remove(newInput.size() - 1);
                }
                
            }
        }
        
        return false;
    }
    public boolean judgePoint24(int[] cards) {
        List<Double> l = new ArrayList<>();
        
        
        for(int c : cards) {
            l.add((double)c);
        }
        
        return canMake24(l);
    }
}