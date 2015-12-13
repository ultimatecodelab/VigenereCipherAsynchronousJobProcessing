package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OutQueue {
	//This class is responsible for holding the finished job
	//Map with Job id and deciphered message
	private static Map<String, DecipheredMessage> outQueueMap  = new ConcurrentHashMap<String,DecipheredMessage>();
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
