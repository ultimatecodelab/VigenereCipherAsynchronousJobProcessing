package ie.gmit.sw;

public class DecipheredMessage {
	private String decipherMessage;

	public String getDecipherMessage() {
		return decipherMessage;
	}

	public void setDecipherMessage(String decipherMessage) {
		this.decipherMessage = decipherMessage;
	}
	public String toString(){
		return getDecipherMessage().toString();
	}
}
