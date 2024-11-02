class Solution {
    private List<List<Integer>> comb(int ind, int[] candidates, int target) {
        
        if(target == 0) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        if( ind == candidates.length) {
            return new ArrayList<>();
        }

        // if(candidates[ind] >)
        List<List<Integer>> skipAndMove = comb(ind+1, candidates, target);

        if(candidates[ind] == target) {
            List<List<Integer>> n = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            l.add(candidates[ind]);
            n.add(l);
            n.addAll(skipAndMove);
            return n;
        }

        List<List<Integer>> takeAndMove = new ArrayList<>();

        if(candidates[ind] <= target) {
            takeAndMove = comb(ind, candidates, target - candidates[ind]);
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> l : takeAndMove) {
                List<Integer> n = new ArrayList<>();
                n.add(candidates[ind]);
                n.addAll(l);
                temp.add(n);
            }
            takeAndMove = temp;
        }

        

        takeAndMove.addAll(skipAndMove);
        return takeAndMove;

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {   
        return comb(0, candidates, target);
        
    }
}