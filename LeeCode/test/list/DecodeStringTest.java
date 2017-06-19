package list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecodeStringTest {

	@Test
	public void testDecodeString() {
		DecodeString ds = new DecodeString();
		assertEquals("aaabcbc", ds.decodeString("3[a]2[bc]"));
		assertEquals("accaccacc", ds.decodeString("3[a2[c]]"));
		assertEquals("abcabccdcdcdef", ds.decodeString("2[abc]3[cd]ef"));
		assertEquals("xyzabcabccdcdcdcdcdcdcdcdcdcdcdef", ds.decodeString("xyz2[abc3[]]11[cd]ef"));
	}

}
