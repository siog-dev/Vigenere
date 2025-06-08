package ie.atu.sw;

public class Runner {

	public static void main(String[] args) {
		String key = "THEQUICK";
		String plainText = "ATTACK THE CASTLE WALL AT DAWN";
		
		try {
			Vigenere cipher = new Vigenere(key);
			String cipherText = cipher.encrypt(plainText);
			System.out.println(cipherText);
			System.out.println(cipher.decrypt(cipherText));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
