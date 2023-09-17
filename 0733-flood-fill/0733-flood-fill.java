class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Stack<Pair<Integer,Integer>> s = new Stack<>();
        Pair<Integer,Integer> source = new Pair<>(sr,sc);
        s.push(source);
        int rows = image.length;
        int cols = image[0].length;
        int sourceColor = image[sr][sc];
        while(!s.isEmpty()){
            Pair<Integer,Integer> temp = s.peek();
            
            int r = temp.getKey();
            int c = temp.getValue();
            s.pop();
            if(image[r][c]==color) continue;
            if(r-1>=0&&image[r-1][c]==sourceColor){
                s.push(new Pair<Integer,Integer>(r-1,c));
            }
            if(r+1<rows&&image[r+1][c]==sourceColor){
                s.push(new Pair<Integer,Integer>(r+1,c));
            }
            if(c-1>=0&&image[r][c-1]==sourceColor){
                s.push(new Pair<Integer,Integer>(r,c-1));
            }
            if(c+1<cols&&image[r][c+1]==sourceColor){
                s.push(new Pair<Integer,Integer>(r,c+1));
            }
            image[r][c]=color;
        }
        return image;
    }
}