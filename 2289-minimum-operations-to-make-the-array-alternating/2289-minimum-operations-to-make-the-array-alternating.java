

class Solution {

	public int minimumOperations(int[] nums) {
		PriorityQueue<Integer[]> pqOdd = new PriorityQueue<>(
                                        (a,b) -> {return b[1] - a[1];}
                                        );
		PriorityQueue<Integer[]> pqEven = new PriorityQueue<>(
                                        (a,b) -> {return b[1] - a[1];}
                                        );
		Map<Integer, Integer> freqOdd = new HashMap<>();
		Map<Integer, Integer> freqEven = new HashMap<>();
		int n = nums.length;
		for(int i = 0; i < n; i++) {
			if(i%2 == 0) {
				freqOdd.put(nums[i], freqOdd.getOrDefault(nums[i], 0) + 1);
} else {
	freqEven.put(nums[i], freqEven.getOrDefault(nums[i], 0) + 1);
}
}
for(Map.Entry<Integer, Integer> mpEntry : freqOdd.entrySet()) {
	pqOdd.add(new Integer[]{mpEntry.getKey(), mpEntry.getValue()});
}
for(Map.Entry<Integer, Integer> mpEntry : freqEven.entrySet()) {
	pqEven.add(new Integer[]{mpEntry.getKey(), mpEntry.getValue()});
}

int maxToRetain = getMaxToRetain(pqOdd, pqEven);
return n - maxToRetain;

}

private int getMaxToRetain(PriorityQueue<Integer[]> pqOdd,PriorityQueue<Integer[]>  pqEven) {
	Integer[] pqOFirst = pqOdd.poll();
	Integer[] pqEFirst = pqEven.poll();
	Integer[] pqOSecond = pqOdd.poll();
	Integer[] pqESecond = pqEven.poll();

    if(pqOFirst == null) pqOFirst = new Integer[]{0,0};
    if(pqEFirst == null) pqEFirst = new Integer[]{0,0};
    if(pqOSecond == null) pqOSecond = new Integer[]{0,0};
    if(pqESecond == null) pqESecond = new Integer[]{0,0};

	if(pqOFirst[0] != pqEFirst[0]) return pqOFirst[1] + pqEFirst[1];

    

	return Math.max(pqOFirst[1] + pqESecond[1], pqOSecond[1] + pqEFirst[1]);
	
}
}
