class Solution {
	public void generateCombinations(int ind, int[] candidates, int target, 
List<Integer> combination, List<List<Integer>> result) {
		if(target < 0 || ind == candidates.length) return;
		if(target == 0)  {
			List<Integer> temp = new ArrayList<>(combination);
			result.add(temp);
			return;
}

combination.add(candidates[ind]);
// generateCombinations(ind, candidates, target - candidates[ind], combination, result);
generateCombinations(ind , candidates, target - candidates[ind], combination, result);
combination.remove(combination.size() - 1);
generateCombinations(ind + 1, candidates, target, combination, result);


}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		generateCombinations(0, candidates, target, combination, result);
		return result;
}
}
