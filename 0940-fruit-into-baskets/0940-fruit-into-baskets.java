class Solution {

	public int totalFruit(int[] fruits) {
		int n = fruits.length;
		int start = 0;
		int end = 0;
		int maxFruits = 0;
		
		Map<Integer, Integer> set = new HashMap<>();
		
while(end < n) {
int currentFruit = fruits[end];
set.put(currentFruit, set.getOrDefault(currentFruit,0)+1);
while(set.size() > 2 && start < end) {
	set.put(fruits[start], set.get(fruits[start])-1);
	if(set.get(fruits[start]) == 0) set.remove(fruits[start]);
	start++;
}
maxFruits = Math.max(maxFruits, (end - start + 1));
end++;
}

return maxFruits;

}
}
