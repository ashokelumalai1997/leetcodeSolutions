class LRUCache {

    static class ListNode {
        int key;
        int val;

        ListNode prev;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    static class DoublyLinkedList {
        ListNode head;
        ListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void remove(ListNode node) {
            if(this.head == node) {
                this.head = this.head.next;
                if(this.head != null) this.head.prev = null;
                node.prev = null;
                node.next = null;
                return;
            }

            if(this.tail == node) {
                this.tail = this.tail.prev;
                this.tail.next = null;
                node.prev = null;
                node.next = null;
                return;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
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
    }

    int cap;
    Map<Integer, ListNode> hm;
    DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.hm = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }
    
    public int get(int key) {
        if(!this.hm.containsKey(key)) {
            return -1;
        }

        ListNode node = this.hm.get(key);

        this.dll.remove(node);
        this.dll.addLast(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node;
        if(this.hm.containsKey(key)) {
            node = this.hm.get(key);
            this.dll.remove(node);
            node.val = value;
        } else {
            node = new ListNode(key, value);
        }
        this.dll.addLast(node);
        this.hm.put(key, node);

        if(this.hm.size() > cap) {
            this.hm.remove(this.dll.head.key);
            this.dll.head = this.dll.head.next;
            if(this.dll.head != null) this.dll.head.prev = null;

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */