package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prime {

    public int nthSuperUglyNumber(int n, int[] primes) {
    	int[] ugly = new int[n];
    	ugly[0] = 1;
    	
    	for (int i = 1; i < n; i++) {
    		// fill in ugly array
    		ugly[i] = Integer.MAX_VALUE;
    			
    	}
    	
    	List<String> l = new ArrayList<>();
    	l = (Arrays.asList("0","1","8"));

    	return ugly[n-1];
        
    }
}
