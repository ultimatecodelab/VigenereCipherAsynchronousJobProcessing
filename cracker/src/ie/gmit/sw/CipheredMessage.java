package ie.gmit.sw;

public class CipheredMessage {
	private String cipheredMessage;

	public String getCipheredMessage() {
		return cipheredMessage;
	}

	public void setDecipherMessage(String cipheredMessage) {
		this.cipheredMessage = cipheredMessage;
	}
	public String toString(){
		return getCipheredMessage();
	}
}
