class Node
	{
	    int data;
	    Node left, right;
	 
	    public Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
public class lca {

	Node root;
	static boolean found = false;
	
	static void inorder(Node root){
		if(root==null)return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
		return;
		
	}
	static boolean finder(Node root,int value,boolean found_local){
		found = found_local;
		if(root==null)return found;
		finder(root.left,value,found);
		if(root.data == value)found = true;
		finder(root.right,value,found);
		return found;
		
	}
	
	private static void leastCommonAns(Node root,int leftData, int rightData) {
		if(root.data == leftData || root.data == rightData){
			System.out.println("LCA is :"+ root.data);
		}else if(finder(root.left,leftData,false) && finder(root.right,rightData,false)){
			System.out.println("LCA is :"+ root.data);
		}else if(finder(root.left,leftData,false) && finder(root.left,rightData,false)){
			leastCommonAns(root.left,leftData,rightData);
		}else if(finder(root.right,leftData,false) && finder(root.right,rightData,false)){
			leastCommonAns(root.right,leftData,rightData);
		}
	}
	
	public static void main(String[] args) {
		lca tree = new lca();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        inorder(tree.root);
	        leastCommonAns(tree.root,4,3);
	}
	
}
