package ie.gmit.sw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class OutQueue {
	private Map<String, DecipheredMessage> outQueue  = new HashMap<String,DecipheredMessage>();
	private static OutQueue outQueueInstance = new OutQueue();
	
	private OutQueue(){
		
	}
	public Map<String,DecipheredMessage> outQueueMap(){
		return outQueue;
	}
	public static  OutQueue OutQueueInstance(){
		return outQueueInstance;
	}
}
