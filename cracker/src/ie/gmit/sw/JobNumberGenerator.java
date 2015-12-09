package ie.gmit.sw;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/*This calss is responsible  generating the job number
 */
public class JobNumberGenerator {
	//generating job number
	private String generateTaskNumber() {
		String taskNumber;
		StringBuilder timeStamp = new StringBuilder(new SimpleDateFormat("mmss").format(Calendar.getInstance().getTime()).replace('_', 'x')).reverse();
		taskNumber =  new String ("T"+((int) (Math.random()*100))+timeStamp.toString());
		return taskNumber;
	}
	//returning job number
	public String toString(){
		return generateTaskNumber();
	}
}
