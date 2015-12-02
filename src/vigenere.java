public class vigenere {
	
	// key is "hack" for sent cipher 
    void vigenereEncrypt(String message, final String key) {
	    String cipherText = "";
	    message = message.toUpperCase();
        int j = 0;
        int messageLength = message.length();
        for (int i = 0; i < messageLength; i++) {
            char c = message.charAt(i);
            if (c !=' ')
        	{
            	cipherText += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
	            j++;
	            j %= key.length();
        	}    
        }
        System.out.println("Encrypted Message with key "+key+":");
		System.out.println("##########################################################");
		System.out.println(cipherText);
		System.out.println("##########################################################");
    }
 
    void vigenereDecrypt(String cipher, final String key) {
        String decipherText = "";
        cipher = cipher.toUpperCase();
        int j = 0;
        int cipherLength = cipher.length();
        for (int i = 0; i < cipherLength; i++) {
            char c = cipher.charAt(i);
            if (c != ' ')
            {
            	decipherText += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            	j++;
                j %= key.length();
            }
        }
        System.out.println("Decrypted Message with key "+key+":");
		System.out.println("##########################################################");
		System.out.println(decipherText);
		System.out.println("##########################################################");
    }
}
