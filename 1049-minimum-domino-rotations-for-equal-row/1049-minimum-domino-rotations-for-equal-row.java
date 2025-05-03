
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int one = minDominoRotation( tops,  bottoms);

        int temp = tops[0];
        tops[0] = bottoms[0];
        bottoms[0] = temp;

        int two = minDominoRotation( tops,  bottoms);

        return Math.min(one, two+1);

    }
	public int minDominoRotation(int[] tops, int[] bottoms) {
		int top = tops[0];
		int bottom = bottoms[0];

		int topCount = 0;
		int bottomCount = 0;

		int n = tops.length;
		
		for(int i = 0; i < n; i++) {
			if(tops[i] != top && topCount != -1) {
				if(bottoms[i] == top) topCount++;
				else topCount = -1;
}




if(bottoms[i] != bottom && bottomCount != -1) {
				if(tops[i] == bottom) bottomCount++;
				else bottomCount = -1;
}

// System.out.println(topCount);
// System.out.println(bottomCount);
// System.out.println();
// System.out.println();
}



if(topCount != -1 && topCount >= (n+1)/2) topCount = n - topCount;

if(bottomCount != -1 && bottomCount >= (n+1)/2) bottomCount = n - bottomCount;

if(topCount == -1 && bottomCount == -1) return -1;

if(topCount == -1) return bottomCount;

if(bottomCount == -1) return topCount;

return Math.min(topCount, bottomCount);


}
}