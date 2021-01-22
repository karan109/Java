class Node{
	Node next;
	int data;
	public Node(int data){
		this.data = data;
	}
}
public class LinkedList{
	private Node head;
	public void append(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next = new Node(data);
	}
	public void prepend(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}
	public void deleteWithValue(int data){
		Node current = head;
		if(head == null){
			return;
		}
		if(head.data == data){
			head = head.next;
			return;
		}
		while(current.next != null){
			if(current.next.data == data){
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	public void print(){
		Node current  = head;
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