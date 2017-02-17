import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    	int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

 
public class Solution {
	List<Integer> list = new ArrayList<Integer>();
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
    	list = Inorder(root,k);
    return list.get(k-1);   
    }
    
    private List<Integer> Inorder(TreeNode root,int k){
    	Inorder(root.left,k);
    	if(count<= k){
    		count++;
    	list.add(root.val);
    	}
    	Inorder(root.right,k);
    	return list;
    }
}