class LRUCache {

    static class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;


        public ListNode(int key, int val) {
            this.key = key;
            this.value = val;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList{
        ListNode head;
        ListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addLast(ListNode node) {
            if(this.head == null) {
                this.head = node;
                this.tail = node;
                return;
            }

            this.tail.next = node;
            node.prev = this.tail;
            this.tail = this.tail.next;
        }

        public void remove(ListNode node) {
            if(this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else if(this.head == node) {
                this.head = this.head.next;
                this.head.prev = null;
            } else if(this.tail == node) {
                this.tail = this.tail.prev;
                this.tail.next = null;
            } else {
                node.next.prev = node.prev;
                node.prev.next = node.next;
            }
            node.prev = null;
            node.next = null;
        }
    }

    Map<Integer, ListNode> hm;
    DoublyLinkedList dll;
    int cap;

    public LRUCache(int capacity) {
        this.hm = new HashMap<>();
        this.dll = new DoublyLinkedList();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(!this.hm.containsKey(key)) {
            return -1;
        }
        ListNode node = this.hm.get(key);
        this.dll.remove(node);
        this.dll.addLast(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        ListNode node;
        if(this.hm.containsKey(key)) {
            node = this.hm.get(key);
            this.hm.remove(key);
            this.dll.remove(node);
            node.value = value;
        } else {
            node = new ListNode(key, value);
        }
        this.dll.addLast(node);
        this.hm.put(key, node);

        if(this.cap < this.hm.size()) {
            this.hm.remove(this.dll.head.key);
            this.dll.remove(this.dll.head);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */