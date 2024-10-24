class Solution {
    public int connectSticks(int[] sticks) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for(int stick : sticks) pq.offer(stick);
        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            result += (first + second);
            pq.offer(first + second);
        }
        return result;
    }
}