package ie.gmit.sw;

//This class is responsible for handling the request. 
//All the complexity of creating a new request is managed from this FacadeClass
public class RequestFacade {
	
	private String requestNumber;
	private int maxKeyLength;
	private String cipherText;
	
	public RequestFacade(int maxKeyLength , String cipherText){
		this.maxKeyLength = maxKeyLength;
		this.cipherText = cipherText;
	}
	
	public void processNewRequest() {
		
		// job number is returned from JobNumberGenerator class and assigned it to taskNumebr
		 String taskNumber = new String(new JobNumberGenerator().toString()); 
		 requestNumber = taskNumber;
		
		//CipheredMessage object to hold the ciphered text
		CipheredMessage cipheredText  = new CipheredMessage(cipherText);
		
		//constructing a new job
		Job job = new Job(taskNumber, cipheredText, maxKeyLength); 
		
		//adding a job to the queue
		InQueue.inqueueInstance().add(job);	
	}
	//returning the Requesting number
	public String getRequestNumber(){
		
		return requestNumber; 
	}
}
