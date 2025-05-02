
class Solution {
	public String pushDominoes(String dominoes) {
		//domnioes = "L" + dominoes + "R";
		char[] dominoChars = dominoes.toCharArray();

		int n = dominoChars.length;
		
		int[] leftDist = new int[n];

		int[] rightDist = new int[n];

		char lastDir = 'L';

		int lastPos = -1;

		for(int i = 0; i < n; i++) {
			if(dominoChars[i] != '.') {
				lastDir = dominoChars[i];
				lastPos = i;
				continue;
}
if(lastDir == 'R') {
	leftDist[i] = i - lastPos;
} else {
	leftDist[i] = Integer.MAX_VALUE;
}

}

lastPos = -1;
lastDir = 'R';
for(int i = n-1; i >= 0; i--) {
			if(dominoChars[i] != '.') {
				lastDir = dominoChars[i];
				lastPos = i;
				continue;
}
if(lastDir == 'L') {
	rightDist[i] = lastPos - i;
} else {
	rightDist[i] = Integer.MAX_VALUE;
}

}
StringBuilder sb = new StringBuilder(dominoes);
for(int i = 0; i < n; i++) {
			if(dominoChars[i] != '.' || leftDist[i] == rightDist[i]) {
				continue;
}
if(leftDist[i] < rightDist[i]) {
	sb.setCharAt(i, 'R');
} else {
sb.setCharAt(i, 'L');
}

}

return sb.toString();


		
}
}
