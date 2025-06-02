package ie.atu.sw;

public class Vigenere {
	private char[] key = null;
	//We need a constructor that ensures the key is passed into the program
	public Vigenere(String key) {
		setKey(key);
	}
	
	public void setKey(String key) {
		// Trim whitespace, ensure the string is uppercase and convert to char array
		this.key = key.trim().toUpperCase().toCharArray(); // Assign the new string to key
	}
	
	/*
	 * Loop over each character in plainText
	 * Look up the tabula recta with the key
	 * Encrypt that character
	 */
	public String encrypt(String plainText) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < plainText.length(); i++) {
			sb.append(getEncryptedCharacter(key[i], plainText.charAt(i)));
		}
		
		return sb.toString();
	}
	
	private char getEncryptedCharacter(char key, char plain) {
		// Loop over each row
		for (int row = 0; row < TABULA_RECTA.length; row++) {
			// If we find the key in column[0] of the current row
			if (TABULA_RECTA[row][0] == key) {
				// Loop over that column
				for (int col = 0; col < TABULA_RECTA[row].length; col++) {
					// In row zero of the current column is equal to our key
					if (TABULA_RECTA[0][col] == plain) {
						// Return the values
						return TABULA_RECTA[row][col];
					}
				}
			}
		}
		// If something was entered that is not found, ignore it - return the plain text
		return plain;
	}
	
	public String decrypt(String cipherText) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < cipherText.length(); i++) {
			sb.append(getDecryptedCharacter(key[i], cipherText.charAt(i)));
		}
		
		return sb.toString();
	}
	
	private char getDecryptedCharacter(char key, char cipher) {
		for (int col = 0; col < TABULA_RECTA[0].length; col++) {
			if (TABULA_RECTA[0][col] == key) {
				for (int row = 0; row < TABULA_RECTA.length; row++) {
					if (TABULA_RECTA[row][col] == cipher) {
						return TABULA_RECTA[row][0];
					}
				}
			}
		}
		
		return cipher;
	}
	
	private static final char[][] TABULA_RECTA = { 
			{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
			{'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A'},
			{'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B'},
			{'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'},
			{'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D'},
			{'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E'},
			{'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F'},
			{'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G'},
			{'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H'},
			{'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I'},
			{'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J'},
			{'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K'},
			{'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L'},
			{'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M'},
			{'O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N'},
			{'P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'},
			{'Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'},
			{'R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'},
			{'S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R'},
			{'T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'},
			{'U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'},
			{'V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'},
			{'W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'},
			{'X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W'},
			{'Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'},
			{'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'}
		};
}
