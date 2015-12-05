package ie.gmit.sw;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InQueue {
	
	private static LinkedList<Job> inQueue = new LinkedList<Job>();
	private static InQueue inqueueInstance = new InQueue();
	
	private InQueue(){
	}
	public static  InQueue inqueueInstance(){
		return inqueueInstance;
	}
	public static LinkedList<Job> inQueue (){
		return inQueue;
	}
	public void add(Job job)
	{
		System.out.println(" adding the job");
		inQueue.add(job);
		//System.out.println("Queue size is: " + inQueue.size());
	}
	
}
