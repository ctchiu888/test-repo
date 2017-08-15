package hash;

import java.util.HashMap;
import java.util.Map;

public class Codec {
	private Map<String, String> urlMap = new HashMap<>();
	private final String TINY_URL = "http://tinyurl.com/";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String hash = Integer.toHexString(longUrl.hashCode());
		urlMap.put(hash, longUrl);
		return TINY_URL + hash;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return urlMap.get(shortUrl.substring(TINY_URL.length()));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
