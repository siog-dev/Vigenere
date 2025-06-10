package ie.atu.sw;

import java.io.*;

public class ElegyProcessor {

	// Put in the Java I/O Code
	public static void main(String[] args) {
		/* ./ is more specific - works cross platform
		 * don't hardcode any filepaths (C:// etc)
		 */
		String file = "./elegy.txt"; // point at our file
		
		try {
			Vigenere v = new Vigenere("THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG"); //Here's our key
			/*
			 * Read through the elegy line by line
			 * encrypt each line and write each line to a file
			 */
			FileWriter out = new FileWriter("out.txt"); // Write stuff out to this + CLOSE
			
			/*
			 * (file) = file
			 * FileInputStream = InputStream, Read a byte. From what? a File.
			 * Get each byte from the file and do what?
			 * InputStreamReader = Convert each byte into a character.
			 * And then do what?
			 * BufferedReader = Buffer it - add it to a buffer
			 * + CLOSE
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null; // Declare a local variable to represent each line
			
			// Loop line by line until null/EOL/End of Line, assign each line to line
			while ((line = br.readLine()) != null) {
				// Encrpyt it
				if (line.length() > Vigenere.MIN_KEY_SIZE) { // If the line is greater than min
					out.write(v.encrypt(line.trim().toUpperCase()) + "\n"); // Then encrypt that line
				}
			}
			
			br.close();
			out.close(); // Close to prevent resource leak
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
