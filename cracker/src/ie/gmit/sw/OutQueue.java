package ie.gmit.sw;

import java.util.HashMap;
import java.util.Map;

public class OutQueue {
	private static Map<String, DecipheredMessage> outQueueMap  = new HashMap<String,DecipheredMessage>();
	private static OutQueue outQueueInstance = new OutQueue();
	
	private OutQueue(){
		
	}
	public static Map<String,DecipheredMessage> outQueueMap(){
		return outQueueMap;
	}
	public static  OutQueue OutQueueInstance(){
		return outQueueInstance;
	}
}
