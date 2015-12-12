package ie.gmit.sw;
/*
 * This class is responsible for periodacally checking for the finished job
 */
public class PeriodicQueueChecker {
	
	private boolean jobStatus; //job status
	
	public PeriodicQueueChecker(String taskNumber) {
		jobStatus = performPeriodicCheck(taskNumber);
	}
	//checks if the job with specific job number is finished or not and returns boolean
	private boolean performPeriodicCheck(String taskNumber) {
		OutQueue.OutQueueInstance();
		if(OutQueue.outQueueMap().containsKey(taskNumber)){
			 jobStatus = true;
		}
		else {
			jobStatus = false;
			
		}
		return jobStatus;
	}
	//returning job status
	public boolean getMessageStatus(){
		return jobStatus;
	}
	
	
}
