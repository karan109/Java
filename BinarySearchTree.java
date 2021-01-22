class BinarySearchTree{
	class Node{
		int data;
		Node right;
		Node left;
		Node parent;
		public Node(int data){this.data = data;}
	}
	public Node root;
	public int insert(int data, Node root){
		if(root == null){
			this.root = new Node(data);
			return 1;
		}
		if(data<root.data){
			if(root.left != null){if(insert(data, root.left) == -1) return -1;}
			else{
				root.left = new Node(data);
				root.left.parent = root;
			}
			return 1;
		}
		else if(data>root.data){
			if(root.right != null){if(insert(data, root.right) == -1) return -1;}
			else{
				root.right = new Node(data);
				root.right.parent = root;
			}
			return 1;
		}
		else return -1;
	}
	public int insert(int data){return this.insert(data, root);}
	public int insert(int data[]){
		for(int i=0;i<data.length;i++){this.insert(data[i], root);}
		return 1;
	}
	public void inprint(){this.inprint(root);System.out.println();}
	public void inprint(Node root){
		if(root.left != null) inprint(root.left);
		System.out.print(root.data+" ");
		if(root.right != null) inprint(root.right);
	}
}