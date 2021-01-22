class Node{
	Node next;
	int data;
	public Node(int data){
		this.data = data;
	}
}
class CircularQueue{
	private Node head;
	private int n;
	public int size(){
		return n;
	}
	public void enqueue(int data){
		if(this.size() == 0){
			head = new Node(data);
			head.next = head;
			n++;
			return;
		}
		Node temp = new Node(head.data);
		head.data = data;
		temp.next = head.next;
		head.next = temp;
		head = temp;
		n++;
	}
	public void dequeue(){
		if(this.size() == 0){
			return;
		}
		if(this.size() == 1){
			head = null;
			n--;
			return;
		}
		head.data = head.next.data;
		head.next = head.next.next;
		n--;
	}
	public int front(){
		return head.data;
	}
	public void print(){
		if(this.size() == 0){
			System.out.println();
			return;
		}
		Node curr = head;
		while(curr.next != head){
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}
}
public class queuecircularlist{
	public static void main(String args[]) {
		CircularQueue q = new CircularQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.print();
		q.dequeue();
		q.enqueue(30);
		q.print();
		q.enqueue(40);
		q.enqueue(50);
		q.print();
		q.dequeue();
		q.print();
		q.dequeue();
		q.print();
	}
}