class MyCircularDeque {

    Node head;
    Node tail;
    int size;
    int capacity;

    class Node {
        int value;
        Node next;
        Node prev;
        Node(int val, Node next, Node prev){
            this.value = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.tail = null;
        this.head = null;
        this.size = 0;
    }
    
    public boolean insertFront(int value) {
        if(this.size == this.capacity) return false;
        Node node = new Node(value, head, null);
        this.size++;
        if(head == null) {
            head = node;
            tail = node;
            return true;
        }
        head.prev = node;
        head = node;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(this.size == this.capacity) return false;
        Node node = new Node(value, null, tail);
        this.size++;
        if(tail == null) {
            head = node;
            tail = node;
            return true;
        }
        tail.next = node;
        tail = node;
        return true;
    }
    
    public boolean deleteFront() {
        if(head == null) return false;
        head = head.next;
        if(head == null) tail = null;
        else head.prev = null;
        this.size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(tail == null) return false;
        tail = tail.prev;
        if(tail == null) head = null;
        else tail.next = null;
        this.size--;
        return true;
    }
    
    public int getFront() {
        if(head == null) return -1;
        return head.value;
    }
    
    public int getRear() {
        if(tail == null) return -1;
        return tail.value;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */