package tree;

import java.util.ArrayList;
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

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		List<String> onePath = new ArrayList<>();
		listBinaryTreePaths(root, onePath, paths);

		return paths;
	}
}
