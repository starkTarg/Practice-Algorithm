package com.practice.tree;


// An object of Res is passed around so that the
// same value can be used by multiple recursive calls.
class Res {
	int val;
}

class MaxPathSum {

	static Node root;
	
	int maxPathSumUtil(Node node, Res res) {

		// Base cases
		if (node == null)
			return 0;

		// Find maximum sum in left and right subtree. Also
		// find maximum root to leaf sums in left and right
		// subtrees and store them in ls and rs
		int ls = maxPathSumUtil(node.left, res);
		int rs = maxPathSumUtil(node.right, res);

			res.val = Math.max(res.val, ls + rs + node.data);
			return Math.max(ls, rs) + node.data;
	}

	// The main function which returns sum of the maximum
	// sum path between two leaves. This function mainly
	// uses maxPathSumUtil()
	int maxPathSum(Node node)
	{
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		maxPathSumUtil(root, res);
		return res.val;
	}

	//Driver program to test above functions
	public static void main(String args[]) {
		MaxPathSum tree = new MaxPathSum();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
		System.out.println("Max pathSum of the given binary tree is "
				+ tree.maxPathSum(root));
	}
}
