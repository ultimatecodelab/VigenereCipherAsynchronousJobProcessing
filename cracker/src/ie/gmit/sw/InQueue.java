/* This class is responsible for adding the Job object in the queue
 */

package ie.gmit.sw;
import java.util.LinkedList;
public class InQueue {
	//queue holding the Job object
	private static LinkedList<Job> inQueue = new LinkedList<Job>();
	//returning one instance of Inqueue
	private static InQueue inqueueInstance = new InQueue();
	
	//default constructor with private constructor.
	private InQueue(){
		
	}
	public static  InQueue inqueueInstance(){
		return inqueueInstance;
	}
	public static LinkedList<Job> inQueue (){
		return inQueue;
	}
	//adding the job in the queue
	public void add(Job job){
		System.out.println(" adding the job");
		inQueue.add(job);
	}
}
