package ie.atu.sw;

import java.io.*;

public class ElegyProcessor {

	// Put in the Java I/O Code
	public static void main(String[] args) {
		/* ./ is more specific - works cross platform
		 * don't hardcode any filepaths (C:// etc)
		 */
		String file = "./elegy.txt";
		
		try {
			Vigenere v = new Vigenere("THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
