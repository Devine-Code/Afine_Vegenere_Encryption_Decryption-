import java.util.Arrays;
import java.util.Scanner;


public class Main {

		
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter you choice:\n1 for Affine cipher\n2 for Vigenere cipher");
		int c = reader.nextInt();
		reader.nextLine();
		switch (c) {
		case 1:
			affine affineCrypt = new affine();
			System.out.println("Please enter\n3 for Encyption\n4 for Decryption:\n");
			int subAffine = reader.nextInt();
			reader.nextLine();
			switch (subAffine) 
			{
				case 3:
					affineCrypt.affineEncrypt();
					break;
				case 4:
					affineCrypt.affineDecrypt();
					break;
				default:
					System.out.println("Wrong input re-run the programm");
					break;
			}
			break;
		case 2:
			vigenere vigenCrypt = new vigenere();
			String key;
		    String message;
		    String cipher;
		    int subVigenere;
		    System.out.println("Please enter your key:\n");
		    key = reader.nextLine().toUpperCase();
		    
		    System.out.println("Please enter\n5 for Encryption\n6 for Decryption\n");
		    subVigenere = Integer.parseInt(reader.nextLine());
		    
		    switch (subVigenere) {
			case 5:
				System.out.println("Please enter your plain text:\n");
			    message = reader.nextLine().toUpperCase();
				vigenCrypt.vigenereEncrypt(message, key);
				break;
			case 6:
				System.out.println("Please enter encrypted message:\n");
			    cipher = reader.nextLine().toUpperCase();
			    vigenCrypt.vigenereDecrypt(cipher, key);
				break;
			default:
				System.out.println("Wrong input re-run the programm");
				break;
			}
		    break;
			
		default:
			System.out.println("Wrong input re-run the programm");
			break;
		}
	}
}
