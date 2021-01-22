/*input
4
1 2 3 4
1 3 2 4
*/
import java.util.Scanner;
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
	}
}
public class traversal{
	// public static void pre(Node root){
	// 	System.out.print(root.data+" ");
	// 	if(root.left != null) pre(root.left);
	// 	if(root.right != null) pre(root.right);
	// }
	// public static void in(Node root){
	// 	if(root.left != null) in(root.left);
	// 	System.out.print(root.data+" ");
	// 	if(root.right != null) in(root.right);
	// }
	// public static void post(Node root){
	// 	if(root.left != null) post(root.left);
	// 	if(root.right != null) post(root.right);
	// 	System.out.print(root.data+" ");
	// }
	public static void pre(Node root){
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while(s.size() != 0){
			Node temp = s.top();
			System.out.print(temp.data+" ");
			s.pop();
			if(temp.right != null) s.push(temp.right);
			if(temp.left != null) s.push(temp.left);
		}
		System.out.println();
	}
	public static void in(Node root){
		Stack<Node> s = new Stack<Node>(); 
		while(root != null || s.size() > 0){
			while (root !=  null){
				s.push(root);
				root = root.left;
            }
			root = s.top();
			System.out.print(root.data + " ");
			s.pop();
			root = root.right;
		}
		System.out.println();
	}
	public static void post(Node root){
		Stack<Node> s = new Stack<Node>();
		Stack<Integer> x = new Stack<Integer>();
		s.push(root);
		while(s.size() != 0){
			Node temp = s.top();
			s.pop();
			x.push(temp.data);
			if(temp.left != null) s.push(temp.left);
			if(temp.right != null) s.push(temp.right);
		}
		while(x.size() != 0){
			System.out.print(x.top()+" ");
			x.pop();
		}
		System.out.println();
	}

	public static Node tree(int[] pre, int[] in, int p1, int p2, int i1, int i2){
		if(i2<i1){return null;}
		int root = pre[p1];
		int ind = -1;
		for(int i=i1;i<=i2;i++){
			if(in[i] == root){
				ind = i;
				break;
			}
		}
		Node c = new Node(root);
		c.left = tree(pre, in, p1+1, p1+ind-i1, i1, ind-1);
		c.right = tree(pre, in, p1+1+ind-i1, p2, ind+1, i2);
		return c;
	}
	public static void post(int[] pre, int[] in, int p1, int p2, int i1, int i2){
		if(i2<i1){return;}
		int root = pre[p1];
		int ind = -1;
		for(int i=i1;i<=i2;i++){
			if(in[i] == root){
				ind = i;
				break;
			}
		}
		post(pre, in, p1+1, p1+ind-i1, i1, ind-1);
		post(pre, in, p1+1+ind-i1, p2, ind+1, i2);
		System.out.print(root + " ");
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] pre = new int[n];
		int[] in = new int[n]; 
		for(int i=0;i<n;i++){
			pre[i] = scan.nextInt();
		}
		for(int i=0;i<n;i++){
			in[i] = scan.nextInt();
		}
		Node root = tree(pre, in, 0, n-1, 0, n-1);
		in(root);
	}
}