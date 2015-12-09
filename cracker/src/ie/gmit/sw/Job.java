/*
 * This class is a Job class. This 
 */
package ie.gmit.sw;
public class Job {
	//instance variables
	private String job_id;
	private CipheredMessage cypherText;
	private int maxKeyLength;
	
	public Job(String jobID, CipheredMessage cypherText,int keyLength){
		//calling the setters
		setJob_id(jobID);
		setCypherText(cypherText);
		setMaxKeyLength(keyLength);
	}
	//getting max key length
	public int getMaxKeyLength() {
		return maxKeyLength;
	}
	//setting the key length
	private void setMaxKeyLength(int maxKeyLength) {
		this.maxKeyLength = maxKeyLength;
	}
	
	public CipheredMessage getCypherText() {
		return cypherText;
	}
	private void setCypherText(CipheredMessage cypherText) {
		this.cypherText = cypherText;
	}
	public String getJob_id() {
		return job_id;
	}
	private void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	
}
