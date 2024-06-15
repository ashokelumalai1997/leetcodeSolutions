class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int[] minimumRoomSizeToTheRight = new int[warehouse.length];
        int[] minimumRoomSizeToTheLeft = new int[warehouse.length];
        int currentMinimumRoomSizeLeft = Integer.MAX_VALUE;
        int currentMinimumRoomSizeRight = Integer.MAX_VALUE;
        for(int i = 0; i < warehouse.length; i ++) {
            minimumRoomSizeToTheLeft[i] = currentMinimumRoomSizeLeft;
            currentMinimumRoomSizeLeft = Math.min(currentMinimumRoomSizeLeft, warehouse[i]);
            minimumRoomSizeToTheRight[warehouse.length - 1 - i] = currentMinimumRoomSizeRight;
            currentMinimumRoomSizeRight = Math.min(currentMinimumRoomSizeRight, warehouse[warehouse.length - 1 - i]);
        }
        PriorityQueue<Integer> roomSizeToCount = new PriorityQueue<>((a,b)->b-a);
        for(int i = 0; i < warehouse.length; i ++) {
            int currentRoomPossibleSize = Math.max(minimumRoomSizeToTheRight[i], minimumRoomSizeToTheLeft[i]);
            if(warehouse[i] <= minimumRoomSizeToTheRight[i] ||
                warehouse[i] <= minimumRoomSizeToTheLeft[i]) {
                    currentRoomPossibleSize = warehouse[i];
            }
            roomSizeToCount.offer(currentRoomPossibleSize);
            System.out.println(currentRoomPossibleSize);
        }
        int result = 0;
        for(int i = boxes.length - 1; i >= 0; i --) {
            if(roomSizeToCount.isEmpty()) break;
            if(roomSizeToCount.peek() >= boxes[i]) {
                result++;
                roomSizeToCount.poll();
                
            }
        }
        return result;
    }
}