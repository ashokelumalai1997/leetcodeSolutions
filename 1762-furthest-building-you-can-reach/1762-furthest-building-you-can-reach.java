class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        /*
        have a top k (ladders) heap

keep a running total of total heights, total heights in heap

at any point top k heights can use ladders. If top total sum - k sum exceeds brcksstop 
        */

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> a-b);

        int sum = 0;

        int prevHeight = heights[0];

        for(int i = 0; i < heights.length; i++) {
            int diff = heights[i] - prevHeight;

            if(diff < 0) diff = 0;

            pq.offer(diff);

            if(pq.size() > ladders) {
                sum += pq.poll();
            }

            if(sum > bricks) return i-1;

            prevHeight = heights[i];
        }

        return heights.length - 1;
    }
}

// heights[]

// bricks

// ladders

// start from 0 


// 1  9 10 11 12

// 15
// 8
// 5
// 2
// 0
// 0

