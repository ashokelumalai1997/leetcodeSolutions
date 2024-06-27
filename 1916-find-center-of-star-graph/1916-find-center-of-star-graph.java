class Solution {
    public int findCenter(int[][] edges) {
        int[] degreeCount = new int[edges.length+1];
        int answer = -1;
        for(int[] edge : edges) {
            if(degreeCount[edge[0] - 1] != 0) {
                answer = edge[0];
                break;
            }
            if(degreeCount[edge[1] - 1] != 0) {
                answer = edge[1];
                break;
            }
            degreeCount[edge[0] - 1]++;
            degreeCount[edge[1] - 1]++;
        }
        return answer;
    }
}