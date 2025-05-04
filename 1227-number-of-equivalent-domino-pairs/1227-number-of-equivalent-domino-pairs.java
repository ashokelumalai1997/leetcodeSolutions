
class Solution {
	public int numEquivDominoPairs(int[][] dominoes) {
		Map<Integer, Map<Integer, Integer>> freqMap = 
			new HashMap<>();

		int count = 0;
		
		for(int[] d : dominoes) {
			int start = d[0];
			int end = d[1];
			if(freqMap.containsKey(start) 
&& freqMap.get(start).containsKey(end)) {
count += freqMap.get(start).get(end);
}
if(start != end) {
if(freqMap.containsKey(end) 
&& freqMap.get(end).containsKey(start)) {
count += freqMap.get(end).get(start);
}

        }

freqMap.putIfAbsent(start, new HashMap<>());
freqMap.get(start).putIfAbsent(end, 0);
int prevCount = freqMap.get(start).get(end);
freqMap.get(start).put(end, prevCount + 1);
}

return count;
}
}
