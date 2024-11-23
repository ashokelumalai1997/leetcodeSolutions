

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
            int low = m-1;
		    for(int j = m-1; j >= 0; j--) {
			    if(box[j][i] == '*') {
                    low = j-1;
                    continue;
                }

                if(box[j][i] == '#') {
                    
                    box[j][i] = '.';
                    box[low][i] = '#';
                    
                    low--;
                }

                
            }
        }
    }
}
    public char[][] rotateTheBox(char[][] box) {


        return BoxRotator.rotateBox(box);
    }
}


