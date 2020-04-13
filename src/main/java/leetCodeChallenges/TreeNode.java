package leetCodeChallenges;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class BinaryTreeSolution {
	public int diameterOfBinaryTree(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		int leftHeight = heightOfBinaryTree(root.left);
		int rightHeight = heightOfBinaryTree(root.right);
		
		int leftDiameter = diameterOfBinaryTree(root.left);
		int rightDiameter = diameterOfBinaryTree(root.right);
		
		int maxDiameter = Math.max(leftHeight+rightHeight+1, Math.max(leftDiameter, rightDiameter));
 		return maxDiameter;
	}

	public int heightOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftNode = heightOfBinaryTree(root.left);
		int rightNode = heightOfBinaryTree(root.right);

		if (leftNode > rightNode) {
			return leftNode + 1;
		} else {
			return rightNode + 1;
		}
	}
}
