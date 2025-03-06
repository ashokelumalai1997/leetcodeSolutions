class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> st = new HashSet<>();


        int n = grid.length;
        int m = grid[0].length;

        int no = n*m;

        int sum = no*(no+1)/2;

        int dup = 0;

        for(int[] numArr : grid) {
            for(int num : numArr) {
                if(st.add(num)) {
                    sum -= num;
                } else {
                    dup = num;
                }
            }
        }

        return new int[] {dup, sum};
    }
}


// o(n)
// o(n)
