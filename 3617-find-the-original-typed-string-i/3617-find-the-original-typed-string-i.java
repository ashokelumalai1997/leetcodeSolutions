


class Solution {
	public int possibleStringCount(String word) {
		int len = word.length();
		
		if(len == 1) return 1;

		char last = word.charAt(0);

		int total = 0;

		int count = 0;
		
		for(int i = 1; i < len; i++) {
			char current = word.charAt(i);
			if(current == last)  { count++; }
			else {
				total += (count);
				count = 0;
}
last = current;
}

total += count;

return (total == 0) ? 1 : 1 + total;
}
}
