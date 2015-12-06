package ie.gmit.sw;

/* 
 * This class contains the ciphered messages entered by the user / client 
 */
public class CipheredMessage {
	
	private String cipheredMessage;
	
	//constructor
	public CipheredMessage(String cipheredText){
		setCipheredMessage(cipheredText);
	}
	
	public String getCipheredMessage() {
		return cipheredMessage;
	}

	private  void setCipheredMessage(String cipheredMessage) {
		this.cipheredMessage = cipheredMessage;
	}
	public String toString(){
		return getCipheredMessage();
	}
}
