class Solution {
	public int numberOfArrays(int[] nums, int lower
, int higher) {
long l = 0;
long h = 0;

long sum = 0;

for(int num : nums) {
	sum += num;
	l = Math.min(l, sum);
	h = Math.max(h, sum);
    // if((higher - lower) - (h - l) < 0) {
    //     System.out.println(higher + " " + lower + " " + h + " " + l);
    // }
    
}


if((higher - lower) - (h - l) < 0) return 0;

int res = (higher - lower) - (int)(h - l) + 1;

// if(res < 0) res = 0;

return res;
}
}
