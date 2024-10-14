class MedianFinder {
    PriorityQueue<Integer> topSet;
    PriorityQueue<Integer> bottomSet;
    public MedianFinder() {
        topSet = new PriorityQueue<>((a,b) -> b-a);
        bottomSet = new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        if(topSet.isEmpty()) {
            topSet.offer(num);
            return;
        }

        int topFirst = topSet.peek();
        // int bottomFirst = bottomSet.first();

        if(topFirst > num) {
            topSet.offer(num);
        } else {
            bottomSet.offer(num);
        }

        int topSize = topSet.size();
        int bottomSize = bottomSet.size();

        if(topSize > bottomSize+1) {
            bottomSet.offer(topSet.poll());
        } else if(bottomSize > topSize+1) {
            topSet.offer(bottomSet.poll());
        }
    }
    
    public double findMedian() {
        
        if(topSet.size() == bottomSet.size()) return (topSet.peek() + bottomSet.peek())/2.0;

        if(topSet.size() > bottomSet.size()) return topSet.peek();

        return bottomSet.peek();

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


//  1 2 3 4 5 

//  topHalf    [1,2]
//  bottomHalf [3,4]