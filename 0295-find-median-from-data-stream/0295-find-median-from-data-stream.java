class MedianFinder {

    private PriorityQueue<Integer> pqMin;

    private PriorityQueue<Integer> pqMax;
    
    public MedianFinder() {
        pqMin = new PriorityQueue<>((a,b) -> a - b);
        pqMax = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum(int num) {
        pqMax.offer(num);

        pqMin.offer(pqMax.poll());

        if(pqMax.size() < pqMin.size()) {
            pqMax.offer(pqMin.poll());
        }
    }
    
    public double findMedian() {
        if(pqMax.size() == pqMin.size()) return (pqMax.peek() + pqMin.peek())/2.0;

        // if(pqMax.size() > pqMin.size()) return pqMax.peek();

        return pqMax.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// 1 2 6 .
// .7 8 10

// 1 2 10 7 8 6

// 1 2 6 
// 7 8 10


// if(num < top of max heap) push it to max heap
// else push it to min heap

