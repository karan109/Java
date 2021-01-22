class Node<T>{
	Node next;
	Node prev;
	T data;
	public Node(T data){
		this.data = data;
	}
}
class Deque<T>{
	private Node<T> head;
	private Node<T> tail;
	private int n;
	public int size(){
		return n;
	}
	public boolean isEmpty(){
		if(this.size() == 0){
			return true;
		}
		return false;
	}
	public void insertFirst(T data){
		if(this.size() == 0){
			head = new Node(data);
			tail = head;
			n++;
			return;
		}
		Node<T> temp = new Node<T>(data);
		temp.next = head;
		head.prev = temp;
		head = temp;
		n++;
	}
	public void insertLast(T data){
		if(this.size() == 0){
			head = new Node<T>(data);
			tail = head;
			n++;
			return;
		}
		Node<T> temp = new Node<T>(data);
		tail.next = temp;
		temp.prev = tail;
		tail = temp;
		n++;
	}
	public void removeLast(){
		if(this.size() == 0){
			return;
		}
		if(this.size() == 1){
			head = null;
			tail = null;
			n--;
			return;
		}
		tail.prev.next = null;
		tail = tail.prev;
		n--;
	}
	public void removeFirst(){
		if(this.size() == 0){
			return;
		}
		if(this.size() == 1){
			head = null;
			tail = null;
			n--;
			return;
		}
		head.next.prev = null;
		head = head.next;
		n--;
	}
	public T last(){
		if(this.size()>0){
			return tail.data;
		}
		else return null;
	}
	public T first(){
		if(this.size()>0){
			return head.data;
		}
		else return null;
	}
	public void print(){
		Node<T> current  = head;
		if(head == null){
			System.out.println();
			return;
		}
		while(current.next != null){
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println(current.data);
	}
}