package ie.gmit.sw;

public class KeyEnumerator {
	
	private Vigenere cypher;
	private QuadgramMap map = null;
	private float bestScore = 0.01f;
	private String bestKey;
	
	public KeyEnumerator() throws Exception {
		/*The file name must be the Quadgrams.txt that contains the word and freq
		 * The file containing the quadram (Quadgrams.txt) is supplied with project.
		 * TION 13168375
		   NTHE 11234972
		   THER 10218035
		   THAT 8980536
		   ......
		 */
		map = new QuadgramMap("Quadgrams.txt");
	}
	
	private char[] getNextKey(char[] key){
		for (int i = key.length - 1; i >=0; i--){
			if (key[i] =='Z'){
				if (i == 0) return null;
				key[i] = 'A';
			}else{
				key[i]++;
				break;
			}
		}
		return key;
	}
	//cracking the cipher with every possible keys.
	public String crackCypher(String cypherText, int maxKeyLength){
		char[] key = null;
		float score = 0.00f;
		int counter = 0;
		for (int j = 3; j <= maxKeyLength; j++){
			key = new char[j];
			for (int k = 0; k < key.length; k++) key[k] = 'A';
			
			do{
				String result = new Vigenere(new String(key)).doCypher(cypherText, false);
				score = map.getScore(result);
				if(new String(key).length()<=maxKeyLength){
				
					if(score > bestScore){
						bestScore = score;
						bestKey = new String(key);	
					}
				}
			}while ((key = getNextKey(key)) != null);
		}
		String yahoo = new Vigenere(bestKey).doCypher(cypherText, false);
		return yahoo;
	}
}