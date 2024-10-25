class PhoneDirectory {
    int[] flag;
    PriorityQueue<Integer> pq;
    public PhoneDirectory(int maxNumbers) {
        flag = new int[maxNumbers];
        pq = new PriorityQueue<>();
        for(int i = 0; i < maxNumbers; i++) {
            flag[i] = 1;
            pq.offer(i);
        }
    }
    
    public int get() {
        if(pq.isEmpty()) return -1;
        int num = pq.poll();
        flag[num] = 0;
        return num;
    }
    
    public boolean check(int number) {
        return flag[number] == 1;
    }
    
    public void release(int number) {
        if(flag[number] == 1) return;
        flag[number] = 1;
        pq.offer(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */