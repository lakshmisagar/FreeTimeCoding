import java.util.Stack;

class TreeNode {
    	int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

 
public class Solution {

	
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
       
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	while(!stack.empty() || cur!=null){
    		if(cur!=null){
    			stack.push(cur);
    			cur = cur.left;
    		}else{
    			TreeNode popped = stack.pop();
    			k--;
    			if(k==0)return popped.val;
    			cur = popped.right;
    		}
    	}
return -1;
    }
}