class LRUCache {

    static class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.value = val;
            prev = null;
            next = null;
        }
    }

    static class DoublyLinkedList {
        ListNode head;
        ListNode tail;
        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(ListNode node) {
            if(this.head == null) {
                this.head = node;
                this.tail = node;
                return;
            }

            this.tail.next = node;
            node.prev = this.tail;
            this.tail = this.tail.next;
        }

        public void removeNode(ListNode node) {
            if(this.head == this.tail) {
                this.head = null;
                this.tail = null;
                return;
            }
            if(this.tail == node) {
                this.tail = this.tail.prev;
                this.tail.next = null;
                node.prev = null;
                node.next = null;
                return;
            }

            if(this.head == node) {
                this.head = this.head.next;
                this.head.prev = null;
                node.prev = null;
                node.next = null;
                return;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            return;
        }
    }


    int cap;
    DoublyLinkedList dll;
    Map<Integer, ListNode> mp;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.dll = new DoublyLinkedList();
        this.mp = new HashMap<>();
    }
    
    /*
    return -1 if key is not there in hm
    get node from hm
    remove it and add it to end
    return the value
    */
    public int get(int key) {
        if(!this.mp.containsKey(key)) {
            return -1;
        }

        ListNode node = this.mp.get(key);
        this.dll.removeNode(node);
        this.dll.addNode(node);
        return node.value;
    }
    
    /*

    entry exists
        update value and move it to end
    entry doesn't exist
        add to end
    if entries go beyond the cap, remove the first node
    */
    public void put(int key, int value) {
        ListNode node;
        if(this.mp.containsKey(key)) {
            node = this.mp.get(key);
            this.dll.removeNode(node);
            node.value = value;
        } else {
            node = new ListNode(key, value);
        }
        this.dll.addNode(node);
        this.mp.put(key, node);

        if(this.mp.size() > this.cap) {
            this.mp.remove(this.dll.head.key);
            this.dll.removeNode(this.dll.head);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */