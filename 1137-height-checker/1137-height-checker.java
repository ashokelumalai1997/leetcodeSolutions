class Solution {
    public int heightChecker(int[] heights) {
        int[] heightsSorted = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            heightsSorted[i] = heights[i];
        }
        Arrays.sort(heightsSorted);
        int results = 0;
        for(int i = 0; i < heights.length; i++) {
            results += heightsSorted[i] != heights[i] ? 1 : 0;
        }
        return results;
    }
}