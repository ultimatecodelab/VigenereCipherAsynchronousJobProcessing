package ie.gmit.sw.rmi;

public class KeyEnumerator {
	
	private Vigenere cypher;
	private QuadgramMap map = null;
	private float bestScore = 0.01f;
	private String bestKey;
	
	public KeyEnumerator() throws Exception {
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
		System.out.println("Enumerated " + counter + " keys.");
		String yahoo = new Vigenere(bestKey).doCypher(cypherText, false);
		System.out.println("Best key is : " + bestKey);
		System.out.println("Best score is : " + bestScore);
		System.out.println("The decrypted text is : \n " + yahoo);
		return yahoo;
	}
	
	public static void main(String[] args) throws Exception {
		String cypherText = "UGSZUZFQDHUQIIUFTOLQOTFQXQHUEUAZYDMEEMPEMUPMKQMDARIQEFQDZMUDEFDUWQETMPRMUXQPFAEFABFTQMPHMZOQAREAOMXXQPUEXMYUOEFMFQYUXUFMZFENGFEUZOQFTQDGEEUMZUZFQDHQZFUAZEAOMXXQPUEXMYUOEFMFQMZPAFTQDVUTMPUSDAGBETMPNQSGZFAETDUZWYDMEEMPEMUPFTQPAIZUZSARMDGEEUMZIMDBXMZQNKFGDWQKXMEFIQQWETAIQPMZWMDMEPUEEMFUERMOFUAZIUFTPQHQXABYQZFEAZFTQSDAGZPUZEKDUMITUOTTQEMUPTMPNQQZYAHUZSUZFTQSAHQDZYQZFERMHAGD";
		new KeyEnumerator().crackCypher(cypherText,4 );
	}
	public String addSpace(String txt){
		StringBuilder sb = new StringBuilder();
		for(int  i = 0 ; i <txt.length() ; i++){
			if(i%4==0){
				sb.append(txt+" ");
			}
		}
		return sb.toString();
	}
}