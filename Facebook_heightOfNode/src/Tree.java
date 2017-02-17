class Node{
		int data;
		Node left, right;
		
		Node(int item){
			this.data = item;
			left = null;
			right = null;
		}
	}

public class Tree {

	static Node root;
	static boolean found = false;
	static int height=1;
	
	private static int height(int r, Node start) {
		System.out.println("height called");
		if(start==null)return -1;
		if(start.data == r) {
			found = true;
		}
		if(!found){
			height  = 1+height(r,start.left);
			height = 1+height(r,start.right);
		}else{
			return 1;
		}
		return height;
		
	/*	if(start==null)return -1;
		if(start.data == r) {
			return 1;
		}
		int lr = height(r,start.left);
		if(lr<0){
			int rr = height(r,start.right);
			return rr == -1 ? 0: 1;
		}
	*/
		
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
	    tree.root.left.left = new Node(4);
	    tree.root.left.right = new Node(5);
	    tree.root.right.left = new Node(6);
	    tree.root.right.right = new Node(7);
	    tree.root.right.right.right = new Node(8);
	}
}