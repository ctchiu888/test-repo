package math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utils.PrintUtil;

public class MathTest {

	@Test
	public void testHammingWeight() {
		Bit b = new Bit();
		assertEquals(2, b.hammingWeight(3));
		assertEquals(3, b.hammingWeight(11));
		assertEquals(1, b.hammingWeight(16));
		assertEquals(1, b.hammingWeight(0x80000000));
		assertEquals(32, b.hammingWeight(0xFFFFFFFF));

	}

	@Test
	public void testIsPowerOfTwo() {
		Bit b = new Bit();
		assertEquals(false, b.isPowerOfTwo(0));
		assertEquals(false, b.isPowerOfTwo(-23));
		assertEquals(true, b.isPowerOfTwo(1));
		assertEquals(true, b.isPowerOfTwo(2));
		assertEquals(true, b.isPowerOfTwo(64));
		assertEquals(true, b.isPowerOfTwo(2048));
		assertEquals(false, b.isPowerOfTwo(2397));
		assertEquals(true, b.isPowerOfTwo(8192));
	}

	@Test
	public void testIsPowerOfThree() {
		Bit b = new Bit();
		assertEquals(false, b.isPowerOfThree(0));
		assertEquals(false, b.isPowerOfThree(-23));
		assertEquals(true, b.isPowerOfThree(1));
		assertEquals(true, b.isPowerOfThree(3));
		assertEquals(true, b.isPowerOfThree(81));
		assertEquals(false, b.isPowerOfThree(2048));
		assertEquals(false, b.isPowerOfThree(2397));
		assertEquals(true, b.isPowerOfThree(19683));
	}

	@Test
	public void testFindNthDigit() {
		Digit d = new Digit();
		assertEquals(5, d.findNthDigit(5));
		assertEquals(1, d.findNthDigit(12));
		assertEquals(0, d.findNthDigit(11));
		assertEquals(6, d.findNthDigit(43));
		assertEquals(5, d.findNthDigit(21));
		assertEquals(3, d.findNthDigit(1000));
		assertEquals(1, d.findNthDigit(1000000000));
	}

	@Test
	public void testMissingNumber() {
		MathSolution sol = new MathSolution();
		assertEquals(2, sol.missingNumber(new int[] { 0, 3, 1, 4, 5 }));
	}

	@Test
	public void testReadBinaryWatch() {
		Bit bit = new Bit();
		PrintUtil.printList(bit.readBinaryWatch(4));
	}

	@Test
	public void testMyPow() {
		MathSolution m = new MathSolution();
		System.out.println(m.myPow(8.88023, 3));
		System.out.println(m.myPow(8.88023, -7));
		System.out.println(m.myPow(2.00000, -2147483648));
	}

	@Test
	public void testArrangeCoins() {
		MathSolution m = new MathSolution();
		assertEquals(1, m.arrangeCoins(1));
		assertEquals(1, m.arrangeCoins(2));
		assertEquals(2, m.arrangeCoins(3));
		assertEquals(2, m.arrangeCoins(4));
		assertEquals(3, m.arrangeCoins(8));
		assertEquals(65535, m.arrangeCoins(2147483647));
	}

	@Test
	public void testHammingDistance() {
		Bit b = new Bit();
		assertEquals(2, b.hammingDistance(1, 4));
	}
}
