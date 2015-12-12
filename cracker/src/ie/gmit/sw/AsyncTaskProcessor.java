package ie.gmit.sw;
import java.rmi.Naming;
import java.util.concurrent.TimeUnit;
import java.rmi.RemoteException;
import javax.servlet.AsyncContext;

//implements Runnable
public class AsyncTaskProcessor implements Runnable {
	
	//instance variable
	private boolean forever = true;
	
	//Remote interface
	private VigenereBreaker vigenereService = null; 
	
	//constructor that takes asyncContext - passed in from CrackerHandler.java
	public AsyncTaskProcessor(AsyncContext context) throws Exception{
		 vigenereService = (VigenereBreaker) Naming.lookup("///cypher-service");
	}
	@Override
	public void run() {
		while(forever){
			try {
				TimeUnit.MILLISECONDS.sleep(2000); //sleep time
				checkQueue(); //checking queue to see if there are any jobs to be processed
				}//end of if
				
			 catch (InterruptedException e) {
			 }	//catch
			
		}//while
	}
	
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
					
					OutQueue.OutQueueInstance();
					//Adding the finished job to the map.
					OutQueue.outQueueMap().put(jobId, decipheredMsg);
				}
				else{
					System.out.println("Not yet processed");
				}
			} catch (RemoteException e) {
				
			}		
		}//end of if
	}
	
}