package ie.gmit.sw;

public class Request {
	
	private String requestNumber;
	
	public Request(int maxKeyLength , String cipherText){
		processNewRequest(maxKeyLength, cipherText);	
	}
	
	private void processNewRequest(int maxKeyLength, String cypherText) {
		// job number is returned from JobNumberGenerator class and assigned it to taskNumebr
		 String taskNumber = new String(new JobNumberGenerator().toString()); 
		 requestNumber = taskNumber;
		
		//CipheredMessage object to hold the ciphered text
		CipheredMessage cipheredText  = new CipheredMessage(cypherText);
		
		//constructing a new job
		Job job = new Job(taskNumber, cipheredText, maxKeyLength); 
		
		//adding a job to the queue
		InQueue.inqueueInstance().add(job);	
		//requestNumber = taskNumber;
	}
	public String getRequestNumber(){
		
		return requestNumber; 
	}
}
