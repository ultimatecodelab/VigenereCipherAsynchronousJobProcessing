package ie.gmit.sw;


public class Vigenere { //Blaise de Vigenere is (incorrectly) accredited with inventing this encryption mechanism
	private char[] key; //Store the cypher key as a char array for convenience
	
	//The tabula recta represents a 26x26 array of characters. For a message of length n, there are 26^n combinations.
	private char[][] tabulaRecta = { 
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
	
	
	//Null constructor
	public Vigenere(){
		
	}
	
	//The class constructor takes a String key as a parameter
	public Vigenere(String key){
		if(key!=null){
			setKey(key); //Pass the parameter to the setKey method below
		}
	}
	
	
	/* Strip leading/trailing whitespace from the String, convert it to upper-case and
	 * then convert it into an array and assign it to the instance variable key  
	 */
	public void setKey(String s){
		
		if(s.trim().length()>0){
		this.key = s.trim().toUpperCase().toCharArray();  
		}
	}

	public void setKey(char[] key){
		if(key!=null){
			this.key = key;  
		}
	}
	
	/* Return the character given by the intersection of the row of the keyword character and the column of the
	 * plain-text character. If no such intersection exists, return the (unencrypted) plain-text character. 
	 */
	private char getEncryptedCharacter(char key, char plain){
		for (int rows = 0; rows < tabulaRecta.length; rows++){
			if (tabulaRecta[rows][0] == key){
				for (int cols = 0; cols < tabulaRecta[rows].length; cols++){
					if (tabulaRecta[0][cols] == plain){
						return tabulaRecta[rows][cols];
					}
				}
			}
		}
		return plain;
	}
	
	/* Return the character in the first column of the row containing the cypher character that intersects with the
	 * column containing the keyword character. 
	 */
	private char getDecryptedCharacter(char key, char cypher){
		for (int cols = 0; cols < tabulaRecta[0].length; cols++){
			if (tabulaRecta[0][cols] == key){
				for (int rows = 0; rows < tabulaRecta.length; rows++){
					if (tabulaRecta[rows][cols] == cypher){
						return tabulaRecta[rows][0];
					}
				}
			}
		}
		return cypher;
	}

	
	/* The duplication in the encrypt() and decrypt() methods invites us to optimise and
	 * simplify the class, by combining their functionality in a new method called doCypher()
	 */
	public String doCypher(char[] text, boolean encrypt) {
		StringBuffer buffer = new StringBuffer();
		
		for (int i = 0; i < text.length; i++) {
			if (text[i] < 'A' || text[i] > 'Z') continue;
			
			int j = 0;
			if(key!=null){
			if (i < key.length) j = i;
			
			if(encrypt){
				buffer.append(getEncryptedCharacter(key[j], text[i]));
			}else{
				buffer.append(getDecryptedCharacter(key[j], text[i]));
			}
			}
			j++;
		}
		return buffer.toString();
	}
	
	public String doCypher(String s, boolean encrypt) {
		char[] text = s.trim().toUpperCase().toCharArray();
		return doCypher(text, encrypt);
	}
	
	public static void main(String[] args) {
		Vigenere v = new Vigenere("JAVA");
		
		String cypherTxt = v.doCypher("Heavens! what a virulent attack! replied the prince, not in the least disconcerted by this reception. "
				+ "He had just entered, wearing an embroidered court uniform, knee breeches, and shoes, and had stars on his breast and a serene "
				+ "expression on his flat face. He spoke in that refined French in which our grandfathers not only spoke but thought, and with the gentle, "
				+ "patronizing intonation natural to a man of importance who had grown old in society and at court. He went up to Anna Pavlovna, kissed her"
				+ " hand, presenting to her his bald, scented, and shining head,and complacently seated himself on the sofa.".trim().toUpperCase(),true);
		
		System.out.println(cypherTxt);
		String plainTxt = v.doCypher(cypherTxt, false);
		System.out.println(plainTxt);
		
	}
}