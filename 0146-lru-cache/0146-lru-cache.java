class LRUCache {
	static class Node {
		Node prev;
		Node next;
		int key;
		int val;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.prev = null;
			this.next = null;
			
}
}

int capacity;

Map<Integer, Node> map;

DoublyLinkedList dll;

public LRUCache(int capacity) {
	this.capacity = capacity;
	this.map = new HashMap<>();
    this.dll = new DoublyLinkedList();
}

public int get(int key) {
	if(!this.map.containsKey(key)) return -1;
	
	Node current = this.map.get(key);

	int val = current.val;
	this.dll.moveToEnd(current);
	return val;
}

public void put(int key, int val) {
	
	if(!this.map.containsKey(key)) {
        if(map.size() == capacity) {
		this.map.remove(this.dll.evict());
}
		this.map.put(key, this.dll.addAtEnd(key, val));
		return;
}


this.map.get(key).val = val;
this.dll.moveToEnd(this.map.get(key));
}



static class DoublyLinkedList {

	Node head;
	Node tail;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
}

public Node addAtEnd(int key, int val) {
	Node current  = new Node(key, val);
	if(this.head == null) {
		this.head = current;
		this.tail = current;
		return current;
}

this.tail.next = current;
current.prev = this.tail;
this.tail = current;
return current;

}

public int evict() {
	
	if(this.head == null) return -1;
	int key = this.head.key;
	this.head = this.head.next;
    if(this.head != null)
	this.head.prev = null;

    if(this.head == null) this.tail = null;

	return key;
}

private void moveToEnd(Node node) {
	if(this.tail == node) return;
	Node current = node;
	if(this.head == node) {
		current = this.head;
		this.head = this.head.next;
		if(this.head != null) {
			this.head.prev = null;
}
} else {
		current.prev.next = current.next;
		current.next.prev = current.prev;
		
}

this.tail.next = current;
current.prev = this.tail;
this.tail = this.tail.next;
}
}
}
