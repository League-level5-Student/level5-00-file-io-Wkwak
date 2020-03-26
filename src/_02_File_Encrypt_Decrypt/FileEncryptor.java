package _02_File_Encrypt_Decrypt;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog(null, "Write the message to be encrypted");
		String key = JOptionPane.showInputDialog(null, "Type in the key you want to shift each letter by");
		int actualKey = Integer.parseInt(key);

		FileEncryptor fe = new FileEncryptor();
		String encryptedInput = fe.encrypt(input, actualKey);

		System.out.println(encryptedInput);
	}

	public String encrypt(String s, int key) {
		String newS = "";
		int newAscii;

		for (int i = 0; i < s.length(); i++) {
			int ascii = (int) s.charAt(i);
			newAscii = ascii + key;
			
			if ((int)Character.toLowerCase(s.charAt(i)) + key > (int)'z') {
				
				newAscii = ascii + key - 26;
				newS += (char) newAscii;
			} else {
				newS += (char) newAscii;
			}

		}

		return newS;
	}
}
