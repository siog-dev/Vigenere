package ie.atu.sw;

import java.io.*;

public class ElegyProcessor {

	public static void main(String[] args) {
		String file = "./out.txt";
		
		try {
			Vigenere v = new Vigenere("THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG");
			FileWriter out = new FileWriter("out1.txt");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.length() > Vigenere.MIN_KEY_SIZE) {
					out.write(v.decrypt(line.trim().toUpperCase()) + "\n");
				}
			}
			
			br.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
