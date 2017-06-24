package string;

public class StringIterator {

	private String compressedString;
	private int index;
	private int count;
	private int len = 0;
	private char curChar;

	StringIterator(String compressedString) throws Exception {
		this.compressedString = compressedString;
		validateCompressedString();
		index = 0;
		len = this.compressedString.length();
		curChar = compressedString.charAt(index);
		index++;
		// TODO need to handle number more than 9
		count = getNextCount();
	}

	private void validateCompressedString() throws Exception {
		if (compressedString == null || compressedString.length() < 2) {
			throw new Exception("Illegal compressed string " + compressedString);
		}
	}

	private int getNextCount() {
		if (!Character.isDigit(compressedString.charAt(index))) {
			return 0;
		}

		int c = 0;
		while (index < compressedString.length() && Character.isDigit(compressedString.charAt(index))) {
			c = c * 10 + (compressedString.charAt(index) - 48);
			index++;
		}

		return c;
	}

	public char next() {
		if (index >= compressedString.length() && count == 0) {
			return ' ';
		}
		if (count == 0) {
			curChar = compressedString.charAt(index);
			index++;
			count = getNextCount();
		}
		count--;
		return curChar;
	}

	public boolean hasNext() {
		if (count > 0 || index < len)
			return true;
		curChar = ' ';
		return false;
	}

}
