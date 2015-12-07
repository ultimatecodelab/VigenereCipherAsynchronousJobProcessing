package ie.gmit.sw;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JobNumberGenerator {
	private String generateTaskNumber() {
		String taskNumber;
		StringBuilder timeStamp = new StringBuilder(new SimpleDateFormat("mmss").format(Calendar.getInstance().getTime()).replace('_', 'x')).reverse();
		taskNumber =  new String ("T"+((int) (Math.random()*100))+timeStamp.toString());
		return taskNumber;
	}
	public String toString(){
		return generateTaskNumber();
	}
}
