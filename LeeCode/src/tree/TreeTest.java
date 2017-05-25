package tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {

	@Test
	public void testLengthLongestPath() {
		LongestPath l = new LongestPath();

		assertEquals(0, l.lengthLongestPath(""));
		assertEquals(8, l.lengthLongestPath("file.ext"));
		assertEquals(20,
				l.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
		assertEquals(
				32,
				l.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
	}

	private TreeNode constructTree() {
		TreeNode root = new TreeNode(8);
		TreeNode L1 = new TreeNode(3);
		TreeNode R1 = new TreeNode(10);

		root.left = L1;
		root.right = R1;
		TreeNode L2_L = new TreeNode(1);
		TreeNode L2_R = new TreeNode(6);
		L1.left = L2_L;
		L1.right = L2_R;
		L2_R.left = new TreeNode(4);
		L2_R.right = new TreeNode(7);

		TreeNode R2_R = new TreeNode(14);
		R1.right = R2_R;
		R2_R.left = new TreeNode(13);

		return root;
	}

	@Test
	public void testClosestValue() {
		BinaryTree bst = new BinaryTree();

		TreeNode root = constructTree();
		assertEquals(4, bst.closestValue(root, 4.428571));
	}

	@Test
	public void testCountNodes() {
		BinaryTree bt = new BinaryTree();
		assertEquals(11, bt.countCompleteTreeNodes(constructTree()));
	}

	@Test
	void testLongestConsecutive() {
		BinaryTree bt = new BinaryTree();
		TreeNode root = constructTree();
		assertEquals(3, bt.longestConsecutive(root));
	}

}
