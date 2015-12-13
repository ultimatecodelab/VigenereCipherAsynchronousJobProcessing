package ie.gmit.sw;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/*This class is responsible  generating the job number
 */
public class JobNumberGenerator {
	//generating job number
	private String generateTaskNumber() {
		String taskNumber;
		StringBuilder timeStamp = new StringBuilder(new SimpleDateFormat("mmss").format(Calendar.getInstance().getTime()).replace('_', 'x')).reverse();
		taskNumber =  new String ("T"+((int) (Math.random()*100))+timeStamp.toString() + (int) (Math.random()*100));
		return taskNumber;
	}
	//returning job number
	@Override
	public String toString(){
		return generateTaskNumber();
	}
}
