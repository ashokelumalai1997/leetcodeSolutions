class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> squares = new HashSet<>();
        int starter = 0;
        while(starter <= Math.sqrt(c)) {
            if(starter*starter*2 == c) return true;
            if(squares.contains(c - starter*starter)) return true;
            squares.add(starter*starter);
            starter++;
        }
        return false;
    }
}