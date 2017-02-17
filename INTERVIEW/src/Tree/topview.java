package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//This file includes Binary Search Tree,
class TreeNode{
	TreeNode left;
	TreeNode right;
	int data;
	
	public TreeNode(int val) {
		data = val;
	}
}

public class topview {
	
//START////////////CREATE BINARY SEARCH TREE //////////////////////////
	private static void binarySearchTreeCreate(int data,TreeNode root){
		
		if(root.data==data){
			root.left = new TreeNode(data);
		}else if(data>root.data){
			if(root.right!=null){
				binarySearchTreeCreate(data, root.right);
			}else{
				root.right = new TreeNode(data);
			}
		}else if(data<root.data){
			if(root.left!=null){
				binarySearchTreeCreate(data, root.left);
			}else{
				root.left = new TreeNode(data);
			}
		}
	}

	private static void printBinaryTree(TreeNode root) {
		inorder(root);
	}
	private static void inorder(TreeNode root) {
		if(root==null)return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
//END////////////CREATE BINARY SEARCH TREE //////////////////////////
	
	
//START////////////LEVEL ORDEDR TRAVERSAL //////////////////////////
	private static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		recursiveLevelTraversal(queue);
	}

	private static void recursiveLevelTraversal(Queue<TreeNode> queue) {
		int count = queue.size();
		while(!queue.isEmpty()){
		while(count!=0){
			TreeNode temp =queue.poll();
			System.out.print(temp.data+",");
			if(temp.left!=null)queue.add(temp.left);
			if(temp.right!=null)queue.add(temp.right);
			count=count-1;
		}
		System.out.println();
		recursiveLevelTraversal(queue);
	}
	}
//END////////////LEVEL ORDEDR TRAVERSAL //////////////////////////
	
	
//START////////////COLUMN ORDEDR TRAVERSAL //////////////////////////	
	private static void columnOrderTraversal(TreeNode root, Map<Integer, ArrayList<Integer>> map, int index) {
		if(root == null)return;
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(map.get(index)== null){
			list.add(root.data);
		}else{
			list = map.get(index);
			list.add(root.data);
		}
		map.put(index, list);
		columnOrderTraversal(root.left,map,index-1);
		columnOrderTraversal(root.right,map,index+1);
		return;
	}
//END////////////COLUMN ORDEDR TRAVERSAL //////////////////////////		
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(10);
		binarySearchTreeCreate(5,root);
		binarySearchTreeCreate(7,root);
		binarySearchTreeCreate(3,root);
		binarySearchTreeCreate(15,root);
		binarySearchTreeCreate(25,root);
		System.out.println("START printBinaryTree");
		printBinaryTree(root);
		System.out.println("END printBinaryTree");
		System.out.println(" ");
		
		
		System.out.println("START levelOrderTraversal");
		levelOrderTraversal(root);
		System.out.println("END levelOrderTraversal");
		System.out.println(" ");
		
		System.out.println("START columnOrderTraversal");
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		columnOrderTraversal(root,map,0);
		for(Map.Entry<Integer,ArrayList<Integer>> entry: map.entrySet()){
			System.out.println(entry.getKey()+" value:"+entry.getValue());
		}
		System.out.println("END columnOrderTraversal");
		
		System.out.println("START TopViewTraversal");
}

}
