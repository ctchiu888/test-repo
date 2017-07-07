package sorting;

public class SearchSolution {

	static final int GUESS_NUMBER = 6;
	int guess(int n) {
		if (n == GUESS_NUMBER) {
			return 0;
		} else if (n > GUESS_NUMBER) {
			return 1;
		} else {
			return -1;
		}
	}
	
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
        	int mid = lo + (hi - lo)/2;
        	if (guess(mid) == 0) {
        		return mid;
        	} else if (guess(mid) == 1) {
        		lo = mid + 1;
        	} else {
        		hi = mid;
        	}
        }
        return lo;
    }
}
