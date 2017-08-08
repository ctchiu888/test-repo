package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class BinaryTree {

	public int closestValue(TreeNode root, double target) {

		int closest = root.val;

		if (target == (double) root.val)
			return root.val;

		// right child tree
		if (target > (double) root.val) {
			if (root.right != null) {
				closest = closestValue(root.right, target);
			} else {
				return root.val;
			}
		} else {
			if (root.left != null) {
				closest = closestValue(root.left, target);
			} else {
				return root.val;
			}
		}

		if (Math.abs(target - (double) root.val) > Math.abs((double) closest
				- target)) {
			return closest;
		}

		return root.val;
	}

	private int leftDepth(TreeNode root) {
		int h = 0;
		TreeNode p = root;
		while (p != null) {
			h++;
			p = p.left;
		}
		return h;
	}

	private int rightDepth(TreeNode root) {
		int h = 0;
		TreeNode p = root;
		while (p != null) {
			h++;
			p = p.right;
		}
		return h;
	}

	public int countCompleteTreeNodes(TreeNode root) {
		if (root == null)
			return 0;
		int leftDepth = leftDepth(root);
		int rightDepth = rightDepth(root);
		int count = 0;

		// left sub-tree is full
		if (leftDepth == rightDepth) {
			count = (1 << leftDepth) - 1;
		} else {
			count = 1 + countCompleteTreeNodes(root.left)
					+ countCompleteTreeNodes(root.right);
		}

		return count;
	}

	private int longCon(TreeNode root, int count, int curTopVal) {
		if (root == null)
			return count;
		count = (curTopVal == root.val - 1) ? count + 1 : 1;
		int left = longCon(root.left, count, root.val);
		int right = longCon(root.right, count, root.val);
		return Math.max(count, Math.max(left, right));
	}

	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(longCon(root.left, 1, root.val),
				longCon(root.right, 1, root.val));
	}

	/**
	 * 257. Binary Tree Paths
	 */

	private String convertListToPathString(List<String> path) {
		if (path.isEmpty())
			return "";

		StringBuilder sb = new StringBuilder();
		sb.append(path.get(0));
		for (int i = 1; i < path.size(); i++) {
			sb.append("->");
			sb.append(path.get(i));
		}

		return sb.toString();
	}

	private void listBinaryTreePaths(TreeNode root, List<String> onePath,
			List<String> paths) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			onePath.add(Integer.toString(root.val));
			paths.add(convertListToPathString(onePath));
			onePath.remove(onePath.size() - 1);
		}

		onePath.add(Integer.toString(root.val));
		listBinaryTreePaths(root.left, onePath, paths);
		listBinaryTreePaths(root.right, onePath, paths);
		onePath.remove(onePath.size() - 1);
	}

	/**
	 * Given a binary tree, return all root-to-leaf paths.
	 * 
	 * For example, given the following binary tree:
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		List<String> onePath = new ArrayList<>();
		listBinaryTreePaths(root, onePath, paths);

		return paths;
	}

	/**
	 * 235. Lowest Common Ancestor of a Binary Search Tree
	 * 
	 * Given a binary search tree (BST), find the lowest common ancestor (LCA)
	 * of two given nodes in the BST.
	 * 
	 * According to the definition of LCA on Wikipedia: ¡°The lowest common
	 * ancestor is defined between two nodes v and w as the lowest node in T
	 * that has both v and w as descendants (where we allow a node to be a
	 * descendant of itself).¡±
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root == null)
			return null;
		if (p == null || q == null)
			return root;

		while ((root.val - p.val) * (root.val - q.val) > 0) {
			if (p.val > root.val) {
				root = root.right;
			} else {
				root = root.left;
			}
		}

		return root;
	}

	/**
	 * 236. Lowest Common Ancestor of a Binary Tree
	 * 
	 * Given a binary tree, find the lowest common ancestor (LCA) of two given
	 * nodes in the tree.
	 * 
	 * According to the definition of LCA on Wikipedia: ¡°The lowest common
	 * ancestor is defined between two nodes v and w as the lowest node in T
	 * that has both v and w as descendants (where we allow a node to be a
	 * descendant of itself).¡±
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// I am the LCA if
		// (1) p in left-subtree and q in right subtree, or vice versa
		// (2) I am p (or q) and p is in one of my subtree
		if (root == null || root == p || root == q)
			return root;

		TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
		TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

		if (leftLca != null && rightLca != null) {
			// this is the case that p and q are in left and right subtree, so
			// the root here is the LCA
			return root;
		}

		if (leftLca == null)
			return rightLca;

		return leftLca;
	}

	/**
	 * 
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		if (root.left == null) {
			return minDepth(root.right) + 1;
		} else if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		TreeNode newLeft = invertTree(root.right);
		TreeNode newRight = invertTree(root.left);
		root.left = newLeft;
		root.right = newRight;

		return root;
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		int dia = 0;

		TreeNode left = root.left;
		TreeNode right = root.right;

		int leftMax = maxDepth(left);
		int rightMax = maxDepth(right);

		int leftDia = diameterOfBinaryTree(left);
		int rightDia = diameterOfBinaryTree(right);

		dia = Math.max(leftMax + rightMax, Math.max(leftDia, rightDia));

		return dia;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(
				p.right, q.right));
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;

		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}

		int midIndex = (nums.length % 2 == 0) ? nums.length / 2 - 1
				: nums.length / 2;
		TreeNode root = new TreeNode(nums[midIndex]);

		if (midIndex - 1 >= 0) {
			root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, midIndex));
		} else {
			root.left = null;
		}

		if (midIndex + 1 < nums.length) {
			root.right = sortedArrayToBST(Arrays.copyOfRange(nums,
					midIndex + 1, nums.length));
		} else {
			root.right = null;
		}
		return root;
	}

	public int treeDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		int l = treeDepth(root.left);
		int r = treeDepth(root.right);

		return Math.abs(l - r) <= 1 && isBalanced(root.left)
				&& isBalanced(root.right);
	}

	/**
	 * 530. Minimum Absolute Difference in BST
	 * 
	 * Given a binary search tree with non-negative values, find the minimum
	 * absolute difference between values of any two nodes.
	 * 
	 * BST is an inorder sorted tree
	 * 
	 * @param root
	 * @return
	 */

	int minDiff = Integer.MAX_VALUE;
	TreeNode prev;

	public int getMinimumDifference(TreeNode root) {
		inorderMinDiff(root);
		return minDiff;
	}

	public void inorderMinDiff(TreeNode root) {
		if (root == null)
			return;
		inorderMinDiff(root.left);
		// calculate minDiff
		if (prev != null) {
			minDiff = Math.min(minDiff, root.val - prev.val);
		}
		prev = root;
		inorderMinDiff(root.right);
	}

	Integer prevVal;
	int count = 1;
	int max = Integer.MIN_VALUE;

	/**
	 * 501. Find Mode in Binary Search Tree
	 * 
	 * Given a binary search tree (BST) with duplicates, find all the mode(s)
	 * (the most frequently occurred element) in the given BST.
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than or
	 * equal to the node's key. The right subtree of a node contains only nodes
	 * with keys greater than or equal to the node's key. Both the left and
	 * right subtrees must also be binary search trees.
	 * 
	 * @param root
	 * @return
	 */
	public int[] findMode(TreeNode root) {
		List<Integer> modeList = new ArrayList<>();
		traverse(root, modeList);
		int[] res = new int[modeList.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = modeList.get(i);
		}
		return res;
	}

	// [1,1,2,null,null,2,3]

	public void traverse(TreeNode root, List<Integer> list) {
		if (root == null)
			return;

		traverse(root.left, list);
		if (prevVal != null) {
			if (root.val == prevVal) {
				count++;
			} else {
				count = 1;
			}
		}

		if (max < count) {
			max = count;
			list.clear();
			list.add(root.val);
		} else if (max == count) {
			list.add(root.val);
		}

		prevVal = root.val;
		traverse(root.right, list);
	}

	/**
	 * 101. Symmetric Tree
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		return isMirror(root.left, root.right);
	}

	private boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;

		if (t1 != null && t2 != null && t1.val == t2.val) {
			return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
		}

		return false;
	}

	/**
	 * 617. Merge Two Binary Trees
	 * 
	 * @param t1
	 * @param t2
	 * @return
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;

		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}

	/**
	 * 112. Path Sum
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null)
			return root.val == sum;

		boolean res = false;
		if (root.left != null) {
			res = res || hasPathSum(root.left, sum - root.val);
		}
		
		if (root.right != null) {
			res = res || hasPathSum(root.right, sum - root.val);
		}

		return res;
	}
}
