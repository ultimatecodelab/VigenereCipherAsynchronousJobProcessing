package ie.gmit.sw;
import java.rmi.Naming;
import java.util.concurrent.TimeUnit;
import java.rmi.RemoteException;
import javax.servlet.AsyncContext;

 //RMI Remote interface has been added to the project references as a jar file(remote Interface)

//implements Runnable
public class AsyncJobProcessorRMIClient implements Runnable {
	
	//instance variable
	private boolean forever = true;
	
	//please note : The  remote INTERFACE  and has been added in a Referenced Library (vigenereRemote.jar)
	private VigenereBreaker vigenereService = null; 
	
	//constructor that takes asyncContext - passed in from CrackerHandler.java
	public AsyncJobProcessorRMIClient(AsyncContext context) throws Exception{
		 vigenereService = (VigenereBreaker) Naming.lookup("///cypher-service");
	}
	@Override
	public void run() {
		while(forever){
			try {
				TimeUnit.MILLISECONDS.sleep(2000); //sleep time
				}//end of if
				
			 catch (InterruptedException e) {
			 }	//catch
			checkQueue(); //checking queue to see if there are any jobs to be processed
		}//while
	}
	@SuppressWarnings("static-access")
	//checking the queue
	private void checkQueue() {
		if(!InQueue.inQueue().isEmpty()){
			Job tempJob = InQueue.inQueue().poll(); //job from the head of the queue
			String jobId = tempJob.getJob_id(); 
			
			String cypherText = new String( tempJob.getCypherText().toString());
			Integer maxLength = new Integer(tempJob.getMaxKeyLength());
			
			System.out.println("Queue is not Empty");
			DecipheredMessage decipheredMsg;
			System.out.println("POOLING THE JOB FROM THE QUEUE");
			
			String msg = null;
			try {
				msg = vigenereService.decrypt(cypherText,maxLength);
				decipheredMsg = new DecipheredMessage(msg);
				
				//if decipheredMessage!null means, deciphering process has finished
				if(decipheredMsg.getDecipherMessage()!=null){
					System.out.println("Adding to Queue-map");
					
					//Adding the finished job to the map.
					OutQueue.OutQueueInstance().outQueueMap().put(jobId, decipheredMsg);
				}
				else{
					System.out.println("Not yet processed");
				}
			} catch (RemoteException e) {
				
			}		
		}//end of if
	}
	
}