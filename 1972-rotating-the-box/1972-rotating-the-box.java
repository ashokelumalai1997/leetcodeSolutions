

class Solution {

    static class BoxRotator {
	public static char[][] rotateBox(char[][] box) {
		int m = box.length;
		int n = box[0].length;
		char[][] rotatedBox = new char[n][m];
		for(int i = 0; i < m; i ++){
			for(int j = 0; j < n; j++) {
				rotatedBox[j][m-1-i] = box[i][j];
            }
        }

        moveStones(rotatedBox);
        return rotatedBox;
    } 

    public static void moveStones(char[][] box) {
	    int m = box.length;
	    int n = box[0].length;
	    for(int i = 0; i < n; i++) {
		    for(int j = m-2; j >= 0; j--) {
			    if(box[j][i] == '.' || box[j][i] == '*') {
				    continue;
                }
                int replacePos = j;
			    for(int k = j+1; k < m; k++) {
				    if(box[k][i] == '.') {
					    replacePos = k;
                    } else {
		                break;
                    }
                }
                if(replacePos != j) {
	                box[replacePos][i] = '#';
	                box[j][i] = '.';
                }
            }
        }
    }
}
    public char[][] rotateTheBox(char[][] box) {


        return BoxRotator.rotateBox(box);
    }
}


