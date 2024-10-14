class MedianFinder {

    PriorityQueue<Integer> topSet;
    PriorityQueue<Integer> bottomSet;

    public MedianFinder() {
        topSet = new PriorityQueue<>((a,b) -> b-a);
        bottomSet = new PriorityQueue<>((a,b) -> a-b);
    }
    
    public void addNum(int num) {
        if(topSet.isEmpty()) {
            topSet.offer(num);
            return;
        }

        if(num <= topSet.peek()) topSet.offer(num);
        else bottomSet.offer(num);
        balance();
    }

    private void balance() {
        if(topSet.size() == bottomSet.size()) return;
        if(topSet.size() > bottomSet.size()) {
            bottomSet.offer(topSet.poll());
            return;
        }

        topSet.offer(bottomSet.poll());
    }
    
    public double findMedian() {
        if(topSet.size() > bottomSet.size()) return topSet.peek();
        else if(bottomSet.size() > topSet.size()) return bottomSet.peek();
        return (topSet.peek() + bottomSet.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */