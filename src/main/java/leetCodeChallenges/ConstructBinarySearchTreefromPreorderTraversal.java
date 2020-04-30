package leetCodeChallenges;

/**
 * Return the root node of a binary search tree that matches 
 * the given preorder traversal. (Recall that a binary search 
 * tree is a binary tree where for every node, any descendant 
 * of node.left has a value < node.val, and any descendant of 
 * node.right has a value > node.val.  Also recall that a 
 * preorder traversal displays the value of the node first, 
 * then traverses node.left, then traverses node.right.)
 * 
 * Example 1:
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 */
public class ConstructBinarySearchTreefromPreorderTraversal {
	
	public static TreeNode buildBST(int [] preorder, int l, int r) {
		if(l>r) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[l]);
		int biggerIndex = l+1;
		while(biggerIndex<=r && preorder[biggerIndex]<preorder[l]) {
			biggerIndex++;
		}
		root.left= buildBST(preorder, l+1, biggerIndex-1);
		root.right=buildBST(preorder, biggerIndex, r);
		
		return root;
	}
	
	public static TreeNode bstFromPreorder(int [] preorder) {
		
		if(preorder == null || preorder.length == 0) {
			return null;
		}
		return buildBST(preorder, 0, preorder.length-1);
	}

}
