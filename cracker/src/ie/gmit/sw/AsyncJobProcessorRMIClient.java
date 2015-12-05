package ie.gmit.sw;


import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.servlet.AsyncContext;

import ie.gmit.sw.rmi.VigenereBreaker;

public class AsyncJobProcessorRMIClient implements Runnable {

	private AsyncContext asyncContext;
	private boolean isCompleted = true;
	private VigenereBreaker vigenereService = null;

	
	public AsyncJobProcessorRMIClient() throws Exception{
		//System.out.println("Constructor kicked in....");
		 vigenereService = (VigenereBreaker) Naming.lookup("///cypher-service");
	}
	@Override
	public void run() {
		while(isCompleted){
			try {
				Thread.sleep(10000);
				System.out.println("Sleeping");	
				}//end of if
				
			 catch (InterruptedException e) {
			 }	//catch
			
			if(!InQueue.inQueue().isEmpty()){
				Job tempJob = InQueue.inQueue().pollLast();
				String jobId = tempJob.getJob_id();
				
				String cypherText = new String( tempJob.getCypherText());
				Integer maxLength = new Integer(tempJob.getMaxKeyLength());
				
				System.out.println("Queue is not Empty");
				DecipheredMessage decipheredMsg = new DecipheredMessage();
				System.out.println("POOLING THE QUEUE OUT");
				
				
				String msg = null;
				try {
					msg = vigenereService.decrypt(cypherText,maxLength);
					decipheredMsg.setDecipherMessage(msg);
					if(decipheredMsg.getDecipherMessage()!=null){
						System.out.println("Adding to map");
						OutQueue.OutQueueInstance().outQueueMap().put(jobId, decipheredMsg);
					}
					else{
						System.out.println("Not yet processed");
					}
				} catch (RemoteException e) {
					
				}
				
				
		}
			
		}//while
	}
	
}
