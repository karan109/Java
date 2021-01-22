class AVLTree{
	class Node{
		int data;
		int h;
		Node right;
		Node left;
		Node parent;
		public Node(int data){this.data = data;}
	}
	public Node root;
	public int insert(int data, Node root){
		Node curr = add(data, root);
		boolean bal = true;
		if(curr == null) return -1;
		while(curr.parent != null){
			curr = curr.parent;
			int h1 = 0, h2 = 0;
			if(curr.left != null) h1 = curr.left.h;
			if(curr.right != null) h2 = curr.right.h;
			if(h1-h2>1 || h1-h2<-1){
				bal = false;
				break;
			}
			curr.h = Math.max(h1+1, h2+1);
		}
		if(bal) return 1;
		if(data<curr.data && data<curr.left.data){
			curr.h--;
			leftRotate(curr);
		}
		else if(data>curr.data && data>curr.right.data){
			curr.h--;
			rightRotate(curr);
		}
		else if(data<curr.data && data>curr.left.data){
			curr.h--;
			curr.left.h--;
			curr.left.right.h++;
			rightRotate(curr.left);
			leftRotate(curr);
		}
		else{
			curr.h--;
			curr.right.h--;
			curr.right.left.h++;
			leftRotate(curr.right);
			rightRotate(curr);
		}
		return 1;
	}
	public void leftRotate(Node curr){
		Node temp = curr.left.right;
		if(root == curr) root = curr.left;
		if(curr.parent != null){
			if(curr.parent.right == curr) curr.parent.right = curr.left;
			else curr.parent.left = curr.left;
		}
		curr.left.parent = curr.parent;
		curr.left.right = curr;
		curr.parent = curr.left;
		curr.left = temp;
		if(temp != null) temp.parent = curr;
	}
	public void rightRotate(Node curr){
		Node temp = curr.right.left;
		if(root == curr) root = curr.right;
		if(curr.parent != null){
			if(curr.parent.right == curr) curr.parent.right = curr.right;
			else curr.parent.left = curr.right;
		}
		curr.right.parent = curr.parent;
		curr.right.left = curr;
		curr.parent = curr.right;
		curr.right = temp;
		if(temp != null) temp.parent = curr;
	}
	public Node add(int data, Node root){
		if(root == null){
			this.root = new Node(data);
			this.root.h = 1;
			return this.root;
		}
		if(data<root.data){
			if(root.left != null) return add(data, root.left);
			root.left = new Node(data);
			root.left.h = 1;
			root.left.parent = root;
			return root.left;
		}
		else if(data>root.data){
			if(root.right != null) return add(data, root.right);
			root.right = new Node(data);
			root.right.h = 1;
			root.right.parent = root;
			return root.right;
		}
		else return null;
	}
	public int insert(int data){return this.insert(data, root);}
	public void inprint(){this.inprint(root);System.out.println();}
	public void inprint(Node root){
		if(root.left != null) inprint(root.left);
		System.out.println(root.data+" "+root.h+" ");
		if(root.right != null) inprint(root.right);
	}
}