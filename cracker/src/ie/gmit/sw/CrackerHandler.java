package ie.gmit.sw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* This class is only responsible for handling the request.  All other tasks
 * has been maintained by other appropriate classes
 */
//Async support to true.
@WebServlet(urlPatterns={"/AsyncJobProcessorRMIClient","/async"},asyncSupported=true)
public class CrackerHandler extends HttpServlet {
	
	//variables
	private static final long serialVersionUID = 1L;
	private String remoteHost = null;
	private String plainTextMessage = "Processing...";
	private String taskNumber;
	private int line_break_at_character = 99;

	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		remoteHost = ctx.getInitParameter("RMI_SERVER"); //Reads the value from the <context-param> in web.xml
	}
	
	
	public StringBuilder sb = new StringBuilder();
	@SuppressWarnings("static-access")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*AsyncContext - Implementation
		 * Asynchronous" means that the API doesn't block the calling thread
		 * Lets consider this situation where you have ONE job J1 with a LOT of 
		 * cipher text to crack. This particular job will obviously gonna take 
		 * more time . Lets imagine there is another client that want to use 
		 * our Vigenere cracker service and his cipher text is not Long / big
		 * as the first job j1 . WE(SECOND CLIENT)CANNOT WAIT UNTIL THE FIRST JOB J1 IS FINISHED
		 * The use of AsyncContext , Executors / ExecutorsService make it possible for asynchronous request process
		 * without blocking the other thread.... If your job is small it should finish
		 * quick compare to the heavy job :)
		 */
		
		//****************ASYNCHRONOUS REQUEST PROCESSING************************
		req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
		final AsyncContext ac = req.startAsync(req,resp);
		ac.setTimeout(10);
		
		
		/*Creates a thread pool that creates new threads as needed, but will 
		 * reuse previously constructed threads when they are available. 
		 * These pools will typically improve the performance of programs 
		 * that execute many short-lived asynchronous tasks. Calls to execute 
		 * will reuse previously constructed threads if available. If no 
		 * existing thread is available, a new thread will be created and 
		 * added to the pool. 
		 * 
		 *///Executor service and newCachedThreadPool (Executors service)
		
		final Executor watcherExecutor = Executors.newCachedThreadPool();
		try {
			// Submitting a task - (AsyncJobProcessorRMIClient) Class implements runnable
			watcherExecutor.execute(new AsyncJobProcessorRMIClient(ac));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//****************ASYNCHRONOUS REQUEST PROCESSING************************
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int maxKeyLength = Integer.parseInt(req.getParameter("frmMaxKeyLength"));
		
		String cypherText = req.getParameter("frmCypherText");
		taskNumber = req.getParameter("frmStatus");
		
		out.print("<html><head><title>Distributed Systems Assignment</title>");		
		out.print("</head>");		
		out.print("<body>");
		
		if (taskNumber == null){
			/* Step one : breaking <br> the line (cipher text)  if its too big (length > 99)
			 * and LineBreaker class is responsible for checking the line (cipherText length.]
			 * The only reason to break the line is, it looks better in a 
			 * browser.
			 * 
			 * Step 2 : Creating the new RequestFacade object - Please check the RequestFacade class.
				RequestFacade class is composed of different classes and has delegated the tasks to different
				objects.
			 */
			
			LineBreaker lineBreaker = new LineBreaker(cypherText,line_break_at_character);
			cypherText = lineBreaker.getStringWithLineBreaks();
			
			//constructing the RequestFacade object - all the complexity of
			//constructing a new Request is hidden here and is managed by the RequestFacade Class itself. 
			RequestFacade requestFacade = new RequestFacade(maxKeyLength, cypherText);
			requestFacade.processNewRequest();
			
			//copying the task number from RequestFacade class.
			taskNumber = new String(requestFacade.getRequestNumber());
			plainTextMessage = "Processing...";

		}else{
			//creating the object of PeriodicQueueChecker to periodically check for a finished job
			PeriodicQueueChecker periodicChecker = new PeriodicQueueChecker(taskNumber);
			
			if(periodicChecker.getMessageStatus()){
				plainTextMessage = OutQueue.OutQueueInstance().outQueueMap().get(taskNumber).toString();
				//if the decrypted text is too big > 100 chars then we are inserting the <br>
				LineBreaker decryptedLineBreaker = new LineBreaker(plainTextMessage,line_break_at_character);
				plainTextMessage = decryptedLineBreaker.getStringWithLineBreaks();
				
			}
			else{
				plainTextMessage = "Processing...";
			}
			
		}
		
		
		out.print("<H1>Processing request for Job#: " + taskNumber + "</H1>");
		out.print("<div id=\"r\"></div>");
		out.print("RMI Server is located at " + remoteHost);
		out.print("<P>Maximum Key Length: " + maxKeyLength);
		
		out.print("<P>CypherText: " + cypherText);
		
		out.print("<P><b>Deciphered Text: " + plainTextMessage );
		/*out.print("<P>This servlet should only be responsible for handling client request and returning responses. Everything else should be handled by different objects.");
		out.print("<P>Note that any variables declared inside this doGet() method are thread safe. Anything defined at a class level is shared between HTTP requests.");				


		out.print("<P> Next Steps:");	
		out.print("<OL>");
		out.print("<LI>Generate a big random number to use a a job number, or just increment a static long variable declared at a class level, e.g. jobNumber");	
		out.print("<LI>Create some type of a message request object from the maxKeyLength, cypherText and jobNumber.");	
		out.print("<LI>Add the message request object to a LinkedList or BlockingQueue (the IN-queue)");			
		out.print("<LI>Return the jobNumber to the client web browser with a wait interval using <meta http-equiv=\"refresh\" content=\"10\">. The content=\"10\" will wait for 10s.");	
		out.print("<LI>Have some process check the LinkedList or BlockingQueue for message requests ");	
		out.print("<LI>Poll a message request from the front of the queue and make an RMI call to the Vigenere Cypher Service");			
		out.print("<LI>Get the result and add to a Map (the OUT-queue) using the jobNumber and the key and the result as a value");	
		out.print("<LI>Return the cyphertext to the client next time a request for the jobNumber is received and delete the key / value pair from the Map.");	
		out.print("</OL>");	*/
		
		out.print("<form name=\"frmCracker\">");
		out.print("<input name=\"frmMaxKeyLength\" type=\"hidden\" value=\"" + maxKeyLength + "\">");
		out.print("<input name=\"frmCypherText\" type=\"hidden\" value=\"" + cypherText + "\">");
		out.print("<input name=\"frmStatus\" type=\"hidden\" value=\"" + taskNumber + "\">");
		out.print("</form>");								
		out.print("</body>");	
		out.print("</html>");	
		
		
		out.print("<script>");
		out.print("var wait=setTimeout(\"document.frmCracker.submit();\", 10000);");
		out.print("</script>");
				
		/*-----------------------------------------------------------------------     
		 *  Next Steps: just in case you removed the above....
		 *-----------------------------------------------------------------------
		 * 1) Generate a big random number to use a a job number, or just increment a static long variable declared at a class level, e.g. jobNumber
		 * 2) Create some type of a "message request" object from the maxKeyLength, cypherText and jobNumber.
		 * 3) Add the "message request" object to a LinkedList or BlockingQueue (the IN-queue)
		 * 4) Return the jobNumber to the client web browser with a wait interval using <meta http-equiv="refresh" content="10">. The content="10" will wait for 10s.
		 * 4) Have some process check the LinkedList or BlockingQueue for "message requests" 
		 * 5) Poll a "message request" from the front of the queue and make an RMI call to the Vigenere Cypher Service
		 * 6) Get the result and add to a Map (the OUT-queue) using the jobNumber and the key and the result as a value
		 * 7) Return the cyphertext to the client next time a request for the jobNumber is received and delete the key / value pair from the Map.
		 */
		
		//You can use this method to implement the functionality of an RMI client
		
		//
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}
}
