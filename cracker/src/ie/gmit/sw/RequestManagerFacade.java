package ie.gmit.sw;

//This class is responsible for handling the request. 
//All the complexity of creating a new request is managed from this RequestManagerFacade class
public class RequestManagerFacade {
	
	private String requestNumber;
	private int maxKeyLength;
	private String cipherText;
	private PeriodicQueueChecker requestStatusChecker;
	
	//default constructor is called for checking the request status
	public RequestManagerFacade(String requestNumber){
		this.requestNumber = requestNumber;
	}
	public RequestManagerFacade(int maxKeyLength , String cipherText){
		this.maxKeyLength = maxKeyLength;
		this.cipherText = cipherText;
		processNewRequest();
	}
	
	private void processNewRequest() {
		
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
	//this method delegate the call to PeriodicQueueChecker class
	public  boolean checkStatus(String requestNumber){
		requestStatusChecker = new PeriodicQueueChecker(requestNumber);
		return requestStatusChecker.getMessageStatus();
	}
	public String getJob(String jobNumber){
		boolean jobStatus = checkStatus(requestNumber);
		if(jobStatus){
			OutQueue.OutQueueInstance();
			return OutQueue.outQueueMap().get(requestNumber).toString();
		}
		else {
			return "Processing....";
		}
	}
}
