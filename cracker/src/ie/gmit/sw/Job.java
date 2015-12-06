package ie.gmit.sw;

public class Job {
	//instance variables
	private String job_id;
	private String cypherText;
	private CipheredMessage cipheredMessage;
	
	private int maxKeyLength;
	
	public Job(String jobID, String cypherText,int keyLength){
		setJob_id(jobID);
		setCypherText(cypherText);
		setMaxKeyLength(keyLength);
	}
	
	public int getMaxKeyLength() {
		return maxKeyLength;
	}

	private void setMaxKeyLength(int maxKeyLength) {
		this.maxKeyLength = maxKeyLength;
	}

	
	
	public String getCypherText() {
		return cypherText;
	}
	private void setCypherText(String cypherText) {
		this.cypherText = cypherText;
	}
	public String getJob_id() {
		return job_id;
	}
	private void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	
}
