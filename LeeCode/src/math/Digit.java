package math;

public class Digit {

	public Digit() {
	}

	/**
	 * 1 digit: 1..9 : 1* 9 = 1*9*(10^(1-1))
	 * 2 digits: 10..99 : 2 * 90 = 2*9*(10^(2-1))
	 * 3 digits: 100..999: 3 * 900 = 3*9*(10^(3-1))
	 * k digits: 10_00 .. 99_99: k * 900_ = k*9*(10^(k-1))
	 * 
	 * (1) Identify which range the number is within
	 * (2) Find out the number
	 * (3) Find out the position
	 * 
	 * @param n
	 * @return
	 */
	public int findNthDigit(int n) {
		int k = 1;
		long lenOfK = 9;

		while (n > lenOfK ) {
			n -= lenOfK;
			k++;
			lenOfK = 9*k*((long) Math.pow(10, k-1));
		}
		
		int baseNumber = (int) Math.pow(10, k-1) - 1;
		int nTh = n % k;
		if (nTh == 0) nTh = k;
		int number = 1 + baseNumber + (n - nTh)/k;
		String s = String.valueOf(number).substring(nTh-1, nTh);
		return Integer.valueOf(s);
	}
	
	public int findNthDigit2(int m) {
	    long n=m; // convert int to long 
	    long start=1,  len=1,  count=9;
	 
	    while(n>len*count){
	        n=n-len*count;
	        len++;
	        count=count*10;
	        start=start*10;
	    }
	 
	    // identify the number
	    start = start + (n-1)/len;
	 
	    // identify the digit
	    return String.valueOf(start).charAt((int)((n-1)%len))-'0';
	}
}
