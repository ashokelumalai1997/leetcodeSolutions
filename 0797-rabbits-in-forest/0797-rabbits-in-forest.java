class Solution {
	public int numRabbits(int[] nums) {
		Map<Integer, Integer> hm = new HashMap<>();
		for(int num : nums) {
			hm.put(num, hm.getOrDefault(num , 0) + 1);
}

int total = 0;

for(Map.Entry<Integer, Integer> mpe : hm.entrySet()) {
	int count = mpe.getKey();
	int occurence = mpe.getValue();
	int res = occurence/(count+1);
	int var = (occurence%(count+1) == 0)? 0 : 1;
	total += (var + res)*(count+1);
}

return total;
}
}
