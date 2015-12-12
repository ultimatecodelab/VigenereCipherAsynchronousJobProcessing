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
	//getting cipher message
	public String getCipheredMessage() {
		return cipheredMessage;
	}

	private  void setCipheredMessage(String cipheredMessage) {
		this.cipheredMessage = cipheredMessage;
	}
	@Override
	public String toString(){
		return getCipheredMessage();
	}
}
