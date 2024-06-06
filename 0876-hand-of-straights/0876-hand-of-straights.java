class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int numberOfGroups = hand.length/groupSize;
        int[][] groupTracker = new int[numberOfGroups][2];
        for(int i = 0; i < numberOfGroups; i ++) {
            groupTracker[i][0] = -1;
        }
        Arrays.sort(hand);
        for(int i = 0; i < hand.length; i ++) {
            for(int j = 0; j < numberOfGroups; j++) {
                if(groupTracker[j][1] != groupSize && 
                        groupTracker[j][0] == hand[i] - 1 || 
                                groupTracker[j][0] == -1) {
                    groupTracker[j][0] = hand[i];
                    groupTracker[j][1]++;
                    break;
                }
                if(j == numberOfGroups-1){
                    return false;
                }
            }
        }
        return true;
    }
}