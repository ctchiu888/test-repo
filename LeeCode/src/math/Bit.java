package math;

public class Bit {
	public int hammingWeight(int n) {
		int weight = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				weight++;
			}
			n = n >>> 1;
		}
		return weight;
	}
	
    public boolean isPowerOfTwo(int n) {
    	if (n <= 0) return false;
    	return (n&(n-1)) == 0 ? true : false;
    }
    
    public boolean isPowerOfThree(int n) {
    	final int maxPowOfThree =  1162261467;
    	return (n > 0 && (maxPowOfThree % n == 0));
    }

}
