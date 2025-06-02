package ie.atu.sw;

public class Runner {

	public static void main(String[] args) {
		String key = "THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG";
		String plainText = "ATTACK THE CASTLE WALL AT DAWN"; //Cryptography version of "Hello, world!"
		
		Vigenere cipher = new Vigenere();
		String cipherText = cipher.encrypt(plainText);
		System.out.println(cipherText);
	}
}
