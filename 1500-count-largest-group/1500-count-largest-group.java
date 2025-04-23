class Solution {
	public int countLargestGroup(int n ) {
		int count = 0;
		Map<Integer, Integer> mp = new HashMap<>();

		int max = 0;

		for(int i = 1; i <= n; i++) {
			int sum = 0;
			int temp = i;
			while(temp != 0) {
				sum += (temp % 10);
				temp /= 10;
}

mp.put(sum, mp.getOrDefault(sum, 0) + 1);
max = Math.max(mp.get(sum), max);
}

for(int mpe : mp.values()) {
	if(mpe == max) count++;
}

return count;
}
}

