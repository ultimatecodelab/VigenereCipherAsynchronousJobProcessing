package ie.gmit.sw;

public class PeriodicQueueChecker {
	
	private boolean messageStatus;
	@SuppressWarnings({ "static-access", "unused" })
	
	public PeriodicQueueChecker(String taskNumber) {
		messageStatus = performPeriodicCheck(taskNumber);
	}
	private boolean performPeriodicCheck(String taskNumber) {
		if(OutQueue.OutQueueInstance().outQueueMap().containsKey(taskNumber)){
			 messageStatus = true;
		}
		else {
			messageStatus = false;
			
		}
		return messageStatus;
	}
	public boolean getMessageStatus(){
		return messageStatus;
	}
	
	
}
