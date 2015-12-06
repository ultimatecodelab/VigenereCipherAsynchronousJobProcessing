package ie.gmit.sw;
import java.util.LinkedList;

public class InQueue {
	private static LinkedList<Job> inQueue = new LinkedList<Job>();
	private static InQueue inqueueInstance = new InQueue();
	
	//default constructor
	private InQueue(){
		
	}
	public static  InQueue inqueueInstance(){
		return inqueueInstance;
	}
	public static LinkedList<Job> inQueue (){
		return inQueue;
	}
	public void add(Job job){
		System.out.println(" adding the job");
		inQueue.add(job);
	}
}
