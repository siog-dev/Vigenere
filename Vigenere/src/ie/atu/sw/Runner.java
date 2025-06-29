package ie.atu.sw;

public class Runner {

	public static void main(String[] args) {
		String key = "THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG";
		String plainText = "ATTACK THE CASTLE WALL AT DAWN UNTIL DUSK WITH GREAT FURY";
		
		try {
			Vigenere cipher = new Vigenere(key);
			cipher.loadKey("./key.txt");
			String cipherText = cipher.encrypt(plainText);
			System.out.println(cipherText);
			System.out.println(cipher.decrypt(cipherText));
			// cipher.saveKey("./key.txt"); // "key.ser" would also work
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			key = null;
		}
		System.out.println(key);
	}
}
