package ie.gmit.sw;

public class Job {
	private String job_id;
	private String cypherText;
	
	private int maxKeyLength;
	
	public int getMaxKeyLength() {
		return maxKeyLength;
	}

	public void setMaxKeyLength(int maxKeyLength) {
		this.maxKeyLength = maxKeyLength;
	}

	public Job(String jobID, String cypherText,int keyLength)
	{
		setJob_id(jobID);
		setCypherText(cypherText);
		setMaxKeyLength(keyLength);
	}
	
	public String getCypherText() {
		return cypherText;
	}
	public void setCypherText(String cypherText) {
		this.cypherText = cypherText;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	
}
