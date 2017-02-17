class Node{
		int data;
		Node left, right;
		
		Node(int item){
			this.data = item;
			left = null;
			right = null;
		}
	}

class Tree {
	
	static Node root;
	
	private static Node LCA(Node node,int n1, int n2) {
	
		if(node == null) return null;
		
		if(node.data == n1 || node.data == n2)return node;

		Node left_lca = LCA(node.left,n1,n2);
		Node right_lca = LCA(node.right,n1,n2);
		
		if(left_lca!=null && right_lca!= null){
			return node;
		}
		
		if(left_lca!=null){
			return left_lca;
		}else{
			return right_lca;
		}
		
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
	    
	    Node result = LCA(root,7,5);
	    System.out.println(result.data);
	
	}

	
	
}
