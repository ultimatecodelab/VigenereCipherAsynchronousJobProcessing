package ie.gmit.sw;
//decrypted message object
public class DecipheredMessage {
	private String decipherMessage;

	public DecipheredMessage(String decipheredMsg){
		setDecipherMessage(decipheredMsg);
	}
	
	public String getDecipherMessage() {
		return decipherMessage;
	}
	
	private void setDecipherMessage(String decipherMessage) {
		this.decipherMessage = decipherMessage;
	}
	
	@Override
	public String toString(){
		return getDecipherMessage().toString();
	}
}
