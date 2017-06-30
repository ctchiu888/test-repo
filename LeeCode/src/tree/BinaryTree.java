package tree;

import java.util.ArrayList;
import java.util.Arrays;
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

		if (Math.abs(target - (double) root.val) > Math.abs((double) closest - target)) {
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
			count = 1 + countCompleteTreeNodes(root.left) + countCompleteTreeNodes(root.right);
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
		return Math.max(longCon(root.left, 1, root.val), longCon(root.right, 1, root.val));
	}

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

	private void listBinaryTreePaths(TreeNode root, List<String> onePath, List<String> paths) {
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

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		List<String> onePath = new ArrayList<>();
		listBinaryTreePaths(root, onePath, paths);

		return paths;
	}

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
		return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;

		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}

		int midIndex = (nums.length % 2 == 0) ? nums.length / 2 - 1 : nums.length / 2;
		TreeNode root = new TreeNode(nums[midIndex]);

		if (midIndex - 1 >= 0) {
			root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, midIndex));
		} else {
			root.left = null;
		}

		if (midIndex + 1 < nums.length) {
			root.right = sortedArrayToBST(Arrays.copyOfRange(nums, midIndex + 1, nums.length));
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

		return Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}
}
