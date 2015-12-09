package ie.gmit.sw;
/*
 * if ciphertext string length is less then 99, we don't need to break the 
	line because its fits well in the screen.
 */
public class LineBreaker {
	//private variables
	private  StringBuilder lineWithBreakline;

	public LineBreaker(String str,int breaking_Point){
		breakString(str, breaking_Point);
	}
	//breaking the string
	private String breakString(String str, int breakingPoint ){
		//if the str length within the range of BREAKING_POINT, return
		if(str.length()<breakingPoint){
			return str;
		}
		lineWithBreakline = new StringBuilder();
		for(int i  = 0 ; i <str.length(); i++){
			if(i%breakingPoint==0 && i!=0){
				lineWithBreakline.append("<br />"); //adding line break
			}
			else{
				lineWithBreakline.append(str.charAt(i));
			}
		}//end of for
		return lineWithBreakline.toString();
	}
	//over-riding the toString method()
	public String toString(){
		return lineWithBreakline.toString();
	}
}
