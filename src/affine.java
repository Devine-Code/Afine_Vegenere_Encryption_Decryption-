import java.util.Scanner;


public class affine {
	
	int a;
	int b;
	int m = 26;
	String plainText = "";
	String cipherText = "";
	String decipherText = "";
	char []alphaMap = new char[26];
	int alphaNumber = 0;
	Scanner reader = new Scanner(System.in);
	public affine()
	{
		
		for(char alpha = 'a'; alpha <= 'z'; alpha++)
		{
			alphaMap[alphaNumber] = alpha;
			alphaNumber++;
		}
		System.out.println("Enter positive coprime key value of 'a':");
		a = reader.nextInt(); 
		reader.nextLine();
		while(gcd(a,m) || a > 26)
		{
			System.out.println("Invalid key. Please enter positive coprime key value of 'a':");
			a = reader.nextInt();
		}
		System.out.println("Enter key value of 'b' greater then 0:");
		b = (int)reader.nextInt();
		reader.nextLine();
		while(b <= 0 || a > 26)
		{
			System.out.println("Invalid key. Please enter key value of 'b' greater then 0:");
			b = reader.nextInt();
		}		
		
	}
	
	int modInverse(int a, int m) 
	{
	    a %= m;
	    int x;
	    for(x = 1; x < m; x++) 
	    {
	        if((a*x) % m == 1)
	        {
	        	break;
	        }
	    }
		return x;
	}
	
	
	boolean gcd(int a, int m)
	{
	    while (m > 0)
	    {
	        int temp = m;
	        m = a % m; 
	        a = temp;
	    }
	    if(a == 1)
	    	return false;
	    else
	    	return true;
	}
	
	void affineEncrypt()
	{
		System.out.println(a+" "+" "+b);
		System.out.println("Please enter plain text:");
		plainText = reader.nextLine().toLowerCase();
		
		for(int  i = 0; i < plainText.length(); i++)
		{			
			if(plainText.charAt(i) != ' ')
			{
				int c = ( (a * java.util.Arrays.binarySearch(alphaMap,plainText.charAt(i)) + b) ) % m;
				cipherText += alphaMap[c];	
			}
			
		}
		System.out.println("Encrypted Message with a: "+a+" and b: "+b);
		System.out.println("##########################################################");
		System.out.println(cipherText);
		System.out.println("##########################################################");
	}
	
	public void affineDecrypt()
	{
		System.out.println("Please encrypted text:");
		cipherText = reader.nextLine().toLowerCase();
		
		int aOfDecypher = modInverse(a,m);
		for(int  i = 0; i <cipherText.length(); i++)
		{			
			if(cipherText.charAt(i) != ' ')
			{
		
				int c = ((aOfDecypher * (java.util.Arrays.binarySearch(alphaMap,cipherText.charAt(i)) - b)));
				c = c % m;
				if(c<0)
				{
					c += m;
				}
				decipherText += alphaMap[c];	
			}
			
		}
		System.out.println("Decrypted Message with a: "+a+" and b: "+b);
		System.out.println("##########################################################");
		System.out.println(decipherText);
		System.out.println("##########################################################");
		
	}
		
}
