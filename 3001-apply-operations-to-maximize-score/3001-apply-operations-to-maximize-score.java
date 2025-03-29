class Solution {

	public int maximumScore(List<Integer> nums, int k) {
		// calculate prime scores for each num
		// calculate nearest left max ele index for each num
		// calculate nearest right max ele index for each num
		// offer range or length of sub array for each num to pq - order by num max
		// poll one by one and multiple score with the num in pq with a min of freq and k , update k

		int[] scores = primeScores(nums);
		
		int[] l = leftMax(scores);

		int[] r = rightMax(scores);

		PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(b[0], a[0]));

        int n = nums.size();
		
		for(int i = 0; i < n; i ++) {
			long range = 1L * (i - l[i]) * (r[i] - i) ;
			pq.offer(new long[] {nums.get(i), range} );
			
}

int score = 1;
		
		while(pq.size() != 0 && k != 0) {
			long[] current = pq.poll();
			long expo = current[1];

			long mul = Math.min((long)k, current[1]);
			k -= (int)mul;

			long pow = exponent(current[0], mul)%1000000007;
			
			score = (int)((1L * score * pow) % 1000000007);

			
}

return score;
		
}

public int exponent1(long num, long expo) {

    System.out.println(num);
    System.out.println(expo);
    System.out.println();


	long s = 1;
	while(expo != 0) {
		// s *= num;
		// s %= 1000000007;

         
        s = (int)(1L * s * num);
		expo--;
}

return (int)s%1000000007;
}

public int exponent(long base, long exp) {

    System.out.println(base);
    System.out.println(exp);
    System.out.println();
    long res = 1;
    long b = base;
    int mod = 1_000_000_007;

    while (exp > 0) {
        if ((exp & 1) == 1)
            res = (res * b) % mod;
        b = (b * b) % mod;
        exp >>= 1;
    }

    return (int) res;
}


	// calculate prime scores for each num
	public int[] primeScores(List<Integer> nums) {
		/*
		*/
		int n = nums.size();
		
		int[] scores = new int[n];
		
		for(int i = 0; i < n; i++) {
			scores[i] = score(nums.get(i));
}

return scores;
		
}

public int score(int num) {
	int factor = 2;

    Set<Integer> set = new HashSet<>();
	
	for(factor = 2; factor * factor <= num; factor++) {
		if(num%factor == 0) {
			while(num%factor == 0) {
				num /= factor;
}
set.add(factor);
}
}

if(num >= 2) set.add(num);


return set.size();
}







//[5,2,3,4,3,2]

public int[] leftMax(int[] scores) {
	int n = scores.length;
	
	Stack<Integer> st = new Stack<>();

	int[] l = new int[n];

	Arrays.fill(l, -1);
	

for(int i = 0; i < n; i++) {
	while(st.size() != 0 && scores[st.peek()] < scores[i]) {
		st.pop();
}
if(st.size() != 0) l[i] = st.peek();
st.add(i);
}	

return l;

}

public int[] rightMax(int[] scores) {
	int n = scores.length;
	
	Stack<Integer> st = new Stack<>();

	int[] r = new int[n];

	Arrays.fill(r, n);
	

for(int i = n-1; i >= 0; i--) {
	while(st.size() != 0 && scores[st.peek()] <= scores[i]) {
		st.pop();
}
if(st.size() != 0)
r[i] = st.peek();
st.add(i);
}	

return r;
}

}
