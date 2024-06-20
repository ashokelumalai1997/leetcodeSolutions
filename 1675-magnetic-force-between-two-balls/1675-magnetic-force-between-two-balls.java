class Solution {
    private int numberOfBallsWithMinDistance(int distance, int[] position) {
        int currentBallPosition = position[0];
        int numberOfBallsPlaced = 1;
        int runningPosition = 1;
        while(runningPosition <= position.length - 1) {
            if(position[runningPosition] - currentBallPosition >= distance) {
                numberOfBallsPlaced ++;
                currentBallPosition = position[runningPosition];
            }
            runningPosition++;
        }
        return numberOfBallsPlaced;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int minPos = Integer.MAX_VALUE;
        int maxPos = Integer.MIN_VALUE;
        for(int pos : position) {
            minPos = Math.min(minPos, pos);
            maxPos = Math.max(maxPos, pos);
        }
        int maxDistance = maxPos - minPos;
        int minDistance = 1;
        int result = maxDistance;
        while(minDistance <= maxDistance) {
            int midDistance = minDistance + (maxDistance - minDistance)/2;
            if(numberOfBallsWithMinDistance(midDistance, position) >= m) {
                minDistance = midDistance + 1;
                result = midDistance;
            } else {
                maxDistance = midDistance - 1;
            }
        }
        return result;
    }
}