class MedianFinder {

    PriorityQueue<Integer> h1;
    PriorityQueue<Integer> h2;

    public MedianFinder() {
        h1 = new PriorityQueue<>((a, b) -> b - a);
        h2 = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        
        if(h1.size() == h2.size()) {
            h1.offer(num);
            h2.offer(h1.poll());
            h1.offer(h2.poll());
        } else {
            h1.offer(num);
            h2.offer(h1.poll());
        }
    }
    
    public double findMedian() {
        if(h1.size() > h2.size()) {
            return h1.peek();
        }
        return (double)(h1.peek() + h2.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */